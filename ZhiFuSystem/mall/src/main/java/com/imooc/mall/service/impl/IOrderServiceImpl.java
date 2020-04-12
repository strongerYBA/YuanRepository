package com.imooc.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.mall.dao.OrderItemMapper;
import com.imooc.mall.dao.OrderMapper;
import com.imooc.mall.dao.ProductMapper;
import com.imooc.mall.dao.ShippingMapper;
import com.imooc.mall.enums.OrderStatusEnum;
import com.imooc.mall.enums.PaymentTypeEnum;
import com.imooc.mall.enums.ProductStatusEnum;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.pojo.*;
import com.imooc.mall.service.ICartService;
import com.imooc.mall.service.IOrderService;
import com.imooc.mall.vo.OrderItemVo;
import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName IOrderServiceImpl
 * @Author Administrator
 * @Date 2020/3/16 22:44
 */
@Slf4j
@Service
public class IOrderServiceImpl implements IOrderService {
    @Resource
    private ShippingMapper shippingMapper;
    @Resource
    private ICartService cartService;
    @Resource
    private ProductMapper productMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderItemMapper orderItemMapper;
    @Override
    @Transactional
    public ResponseVo<OrderVo> create(Integer uid, Integer shippingId) {
        log.info("创建订单 开始。。。。");
        //收获地址要校验（总之要查出来的）
        Shipping shipping = shippingMapper.selectByUidAndShippingId(uid, shippingId);
        if (shipping == null) {
            log.error("通过uid和shippingId获取收获地址为null");
            return ResponseVo.error(ResponseEnum.SHIPPING_NOT_EXIST);
        }
        //通过uid获取购物车，校验（是否有商品，库存）
        List<Cart> collect = cartService.listForCart(uid).stream().filter(Cart::getProductSelected)
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(collect)){
            log.error("通过uid获取购物车信息为null");
            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
        }
        //如何优化，for循环里面查询数据库。采用in来查。
        //获取catList里面的products
        Set<Integer> productIdSet = collect.stream().map(Cart::getProductId).collect(Collectors.toSet());
        List<Product> products = productMapper.selectByProductIdSet(productIdSet);
        Map<Integer,Product> productMap= products.stream()
                .collect(Collectors.toMap(Product::getId,
                        product->product));
        List<OrderItem> orderItemList = new ArrayList<>();
        Long orderNo = generateOrderNo();
        for (Cart cart : collect) {
            //根据productId查询数据库。
            Product product = productMap.get(cart.getProductId());
            if (product == null){
                //是否有该商品。
                return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST,"商品不存在 ProductId() = "+
                        cart.getProductId());
            }
            //商品的上下架状态。
            if (!ProductStatusEnum.ON_SALE.getCode().equals(product.getStatus())){
                return ResponseVo.error(ResponseEnum.PRODUCT_DELETE_OR_OFF_SALE,"商品不是在售状态 : "+product.getName());
            }
            //库存是否充足。
            if (product.getStock() < cart.getQuantity()){
                return ResponseVo.error(ResponseEnum.PRODUCT_STOCK_ERROR,"库存不正确"+
                        product.getName());
            }
            OrderItem orderItem =  buildOrderItem(uid,orderNo,product,cart.getQuantity());
            orderItemList.add(orderItem);

            //减库存
            product.setStock(product.getStock() - cart.getQuantity());
            int insertSelective = productMapper.updateByPrimaryKeySelective(product);
            if (insertSelective <= 0){
                return ResponseVo.error(ResponseEnum.ERROR);
            }
        }
        //计算总价，只计算被选中的商品。（有可能有优惠券，逻辑更复杂。）
        //生成订单，入库：order和orderItem表。（有任何一个表出现问题，都会出现问题，所以要用事务进行控制。）
        Order order = buildOrder(orderNo,uid,shippingId,orderItemList);
        int rowForOrder = orderMapper.insertSelective(order);
        if (rowForOrder <= 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        //批量写入。
        int rowForOrderItem = orderItemMapper.batchInsert(orderItemList);
        if (rowForOrderItem <= 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }


        //更新购物车（选中的商品删除，更新）redis有事务（打包命令），不能回滚的事务，所以更新购物车，需要重新遍历异常，避免不能回滚。
        for (Cart cart : collect) {
            cartService.delete(uid,cart.getProductId());
        }
        //构造OrderVo对象。
        OrderVo orderVo = buildOrderVo(order,orderItemList,shipping);
        return ResponseVo.success(orderVo);
    }

    @Override
    public ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> list = orderMapper.selectByUid(uid);
        Set<Long> orderNoSets = list.stream()
                .map(Order::getOrderNo)
                .collect(Collectors.toSet());
        List<OrderItem> orderItemList = orderItemMapper.selectOrderItemByOrderId(orderNoSets);
        Map<Long,List<OrderItem>> orderItemMap = orderItemList.stream()
                .collect(Collectors.groupingBy(OrderItem::getOrderNo));
        Set<Integer> shippingIdSet = list.stream()
                .map(Order::getShippingId)
                .collect(Collectors.toSet());
        List<Shipping> shippingList = shippingMapper.selectByShippingIdSet(shippingIdSet);
        Map<Integer,Shipping> shippingMap = shippingList
                .stream()
                .collect(Collectors.toMap(Shipping::getId,shipping -> shipping));
        List<OrderVo> orderVoList = new ArrayList<>();
        for (Order order : list) {
            //此处要注意，从order中获取对应的orderItem。和orderShippingId 对应的Shipping。
            OrderVo orderVo = buildOrderVo(order, orderItemMap.get(order.getOrderNo()), shippingMap.get(order.getShippingId()));
            orderVoList.add(orderVo);
        }
        PageInfo info = new PageInfo(list);
        info.setList(orderVoList);
        return ResponseVo.success(info);
    }

    @Override
    public ResponseVo<OrderVo> detail(Integer uid, Long orderNo) {
        Order order = orderMapper.selectByOrderNo(orderNo);
        if (order == null || !order.getUserId().equals(uid)){
            log.error("订单不存在。。。");
            return ResponseVo.error(ResponseEnum.ORDER_NOT_EXIST);
        }
        Set<Long> orderNoSets = new HashSet<>();
        orderNoSets.add(order.getOrderNo());
        List<OrderItem> orderItemList = orderItemMapper.selectOrderItemByOrderId(orderNoSets);
        Shipping shipping = shippingMapper.selectByPrimaryKey(order.getShippingId());
        OrderVo orderVo = buildOrderVo(order, orderItemList, shipping);
        return ResponseVo.success(orderVo);
    }

    @Override
    public ResponseVo cancel(Integer uid, Long orderNo) {
        Order order = orderMapper.selectByOrderNo(orderNo);
        if (order == null || !order.getUserId().equals(uid)){
            log.error("订单不存在。。。");
            return ResponseVo.error(ResponseEnum.ORDER_NOT_EXIST);
        }
        //只有未付款订单可以取消，看公司业务。
        if (!order.getStatus().equals(OrderStatusEnum.NO_PAY)){
            return ResponseVo.error(ResponseEnum.ORDER_STATUS_ERROR);
        }
        order.setStatus(OrderStatusEnum.CANCELED.getCode());
        order.setCloseTime(new Date());
        int insertSelective = orderMapper.insertSelective(order);
        if (insertSelective<=0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success() ;
    }

    @Override
    public void paid(Long orderNo) {
        Order order = orderMapper.selectByOrderNo(orderNo);
        if (order == null){
            //可以添加告警。
            throw new RuntimeException(ResponseEnum.ORDER_NOT_EXIST.getDesc()+"订单id ："+orderNo);
        }
        //只有未付款订单可以变成已付款。
        if (!order.getStatus().equals(OrderStatusEnum.NO_PAY)){
            throw new RuntimeException(ResponseEnum.ORDER_STATUS_ERROR.getDesc()+"订单id ："+orderNo);
        }
        order.setStatus(OrderStatusEnum.PAID.getCode());
        order.setPaymentTime(new Date());
        int insertSelective = orderMapper.updateByPrimaryKeySelective(order);
        if (insertSelective<=0){
           throw new RuntimeException("将订单更新为支付状态失败,订单id ："+orderNo);
        }
    }

    private OrderVo buildOrderVo(Order order, List<OrderItem> orderItemList, Shipping shipping) {
        OrderVo orderVo = new OrderVo();
        BeanUtils.copyProperties(order,orderVo);
        List<OrderItemVo> orderItemVos   = orderItemList.stream().map(e -> {
            OrderItemVo orderItemVo = new OrderItemVo();
            BeanUtils.copyProperties(e, orderItemVo);
            return orderItemVo;
        }).collect(Collectors.toList());
        orderVo.setOrderItemVoList(orderItemVos);
        if (shipping != null){
            orderVo.setShippingId(shipping.getId());
            orderVo.setShippingVo(shipping);
        }
        return orderVo;
    }

    private Order buildOrder(Long orderNo, Integer uid, Integer shippingId,
                             List<OrderItem> list) {
        BigDecimal payment = list.stream()
                .map(OrderItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setUserId(uid);
        order.setShippingId(shippingId);
        order.setPayment(payment);
        order.setPaymentType(PaymentTypeEnum.PAY_ON_LINE.getCode());
        order.setPostage(0);
        order.setStatus(OrderStatusEnum.NO_PAY.getCode());
        return order;
    }

    /**
     * 企业级：分布式唯一id/主键
     * @return
     */
    private Long generateOrderNo() {
        return System.currentTimeMillis()+new Random().nextInt(999);
    }

    private OrderItem buildOrderItem(Integer uid,Long orderNo
            ,Product product,Integer quantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setUserId(uid);
        orderItem.setOrderNo(orderNo);
        orderItem.setProductId(product.getId());
        orderItem.setProductImage(product.getMainImage());
        orderItem.setProductName(product.getName());
        orderItem.setCurrentUnitPrice(product.getPrice());
        orderItem.setQuantity(quantity);
        orderItem.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        return orderItem;
    }
}
