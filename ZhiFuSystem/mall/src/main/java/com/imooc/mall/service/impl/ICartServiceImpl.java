package com.imooc.mall.service.impl;

import com.google.gson.Gson;
import com.imooc.mall.dao.ProductMapper;
import com.imooc.mall.enums.ProductStatusEnum;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.form.CartUpdateForm;
import com.imooc.mall.pojo.Cart;
import com.imooc.mall.pojo.Product;
import com.imooc.mall.service.ICartService;
import com.imooc.mall.vo.CartProductVo;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ICartServiceImpl
 * @Author Administrator
 * @Date 2020/3/12 15:36
 */
@Service
public class ICartServiceImpl implements ICartService {

    public static final String CART_REDIS_KEY_TEMPLATE = "cart_%d";
    @Resource
    private ProductMapper productMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private Gson gson = new Gson();
    /**
     * 添加购物车
     * @param cartAddForm
     * @return
     */
    @Override
    public ResponseVo<CartVo> add(Integer uid,CartAddForm cartAddForm) {
        Integer quantity = 1;
        Product product = productMapper.selectByPrimaryKey(cartAddForm.getProductId());
        //1、判断商品是否存在。
        if (product == null) {
            return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST);
        }
        //2、商品是否正常在售
        if (!product.getStatus().equals(ProductStatusEnum.ON_SALE.getCode())) {
            return ResponseVo.error(ResponseEnum.PRODUCT_DELETE_OR_OFF_SALE);
        }
        //3、商品库存是否充足。
        if (product.getStock() <= 0) {
            return ResponseVo.error(ResponseEnum.PRODUCT_STOCK_ERROR);
        }
        //写入redis。
//            1、引入依赖。s的key可以自己定义。
        //key:cart_1 rediopsForValue().set(String.format(CART_REDIS_KEY_TEMPLATE,uid),
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uid);
        String value = hashOperations.get(redisKey, String.valueOf(product.getId()));
        Cart cart;
        if (StringUtils.isEmpty(value)){
            //没有该商品。新增
            cart = new Cart(product.getId(), quantity, cartAddForm.getSelected());
        }else{
            //已经有了该商品。数量+1.
            cart = gson.fromJson(value, Cart.class);
            cart.setQuantity(cart.getQuantity() + quantity);
        }
        hashOperations.put(redisKey,
                String.valueOf(product.getId()),
                gson.toJson(cart));
        return list(uid);
    }

    @Override
    public ResponseVo<CartVo> list(Integer uuid) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uuid);
        Map<String, String> entries = hashOperations.entries(redisKey);
        CartVo cartVo = new CartVo();
        List<CartProductVo> cartProductVosList = new ArrayList<>();
        boolean selectAll = true;
        Integer cartProductTotalQuantity = 0;
        BigDecimal cartTotalPrice = BigDecimal.ZERO;
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            Integer productId = Integer.valueOf(entry.getKey());
            Cart cart = gson.fromJson(entry.getValue(), Cart.class);
            //TODO 需要优化，使用mysql里的in查询所有数据。
            Product product = productMapper.selectByPrimaryKey(cart.getProductId());
            if (product != null){
                CartProductVo productVo = new CartProductVo(
                        productId,cart.getQuantity(),
                        product.getName(),product.getSubtitle(),
                        product.getMainImage(),product.getPrice(),
                        product.getStatus(),product.getPrice().multiply(BigDecimal.valueOf(cart.getQuantity())),
                        product.getStock(),cart.getProductSelected());
                cartProductVosList.add(productVo);
                //有一个没有选中就不叫全选。
                if (!cart.getProductSelected()){
                    selectAll = false;
                }
                //所有选中的商品总价累加。
                if (cart.getProductSelected()){
                    cartTotalPrice = cartTotalPrice.add(productVo.getProductTotalPrice());
                }
            }
            cartProductTotalQuantity += cart.getQuantity();
        }
        //有一个没有选中就不叫全选。
        cartVo.setSelectedAll(selectAll);
        cartVo.setCartTotalPrice(cartTotalPrice);
        cartVo.setCartTotalQuantity(cartProductTotalQuantity);
        cartVo.setCartProductVoList(cartProductVosList);
        return ResponseVo.success(cartVo);
    }

    @Override
    public ResponseVo<CartVo> update(Integer uuid, Integer productId, CartUpdateForm form) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uuid);
        String value = hashOperations.get(redisKey, String.valueOf(productId));
        if (StringUtils.isEmpty(value)){
            //没有该商品。数据有问题。
            return ResponseVo.error(ResponseEnum.CART_PRODUCT_NOT_EXIST);
        }
        //已经有了该商品。修改内容；。
        Cart cart = gson.fromJson(value, Cart.class);
        if (form.getQuantity() != null && form.getQuantity() >= 0){
            cart.setQuantity(form.getQuantity());

        }
        if (form.getSelected()!=null){
            cart.setProductSelected(form.getSelected());
        }
        hashOperations.put(redisKey,String.valueOf(productId),gson.toJson(cart));
        return list(uuid);
    }

    @Override
    public ResponseVo<CartVo> delete(Integer uuid, Integer productId) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uuid);
        String value = hashOperations.get(redisKey, String.valueOf(productId));
        if (StringUtils.isEmpty(value)){
            //没有该商品。数据有问题。
            return ResponseVo.error(ResponseEnum.CART_PRODUCT_NOT_EXIST);
        }
        hashOperations.delete(redisKey,String.valueOf(productId));
        return list(uuid);
    }

    @Override
    public ResponseVo<CartVo> selectAll(Integer uuid) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uuid);
        List<Cart> carts = listForCart(uuid);
        for (Cart cart : carts) {
            //设置选中。
            cart.setProductSelected(true);
            //set到redis中
            hashOperations.put(redisKey,String.valueOf(cart.getProductId()),gson.toJson(cart));

        }
        return list(uuid);
    }

    @Override
    public ResponseVo<CartVo> unSelectAll(Integer uuid) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uuid);
        List<Cart> carts = listForCart(uuid);
        for (Cart cart : carts) {
            //设置选中。
            cart.setProductSelected(false);
            //set到redis中
            hashOperations.put(redisKey,String.valueOf(cart.getProductId()),gson.toJson(cart));

        }
        return list(uuid);
    }

    @Override
    public ResponseVo<Integer> sum(Integer uid) {
        Integer reduce = listForCart(uid).stream()
                .map(Cart::getQuantity)
                .reduce(0, Integer::sum);
        return ResponseVo.success(reduce);
    }
    public List<Cart> listForCart(Integer uuid){
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uuid);
        Map<String, String> entries = hashOperations.entries(redisKey);
        List<Cart>  cartList = new ArrayList<>();
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            cartList.add(gson.fromJson(entry.getValue(),Cart.class));
        }
        return cartList;
    }
}
