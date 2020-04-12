//package com.imooc.mall.service;
//
//import com.github.pagehelper.PageInfo;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.imooc.mall.MallApplicationTests;
//import com.imooc.mall.enums.ResponseEnum;
//import com.imooc.mall.form.CartAddForm;
//import com.imooc.mall.vo.CartVo;
//import com.imooc.mall.vo.OrderVo;
//import com.imooc.mall.vo.ResponseVo;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//@Slf4j
//@Transactional
//public class IOrderServiceTest extends MallApplicationTests {
//    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
//    @Resource
//    private IOrderService orderService;
//    public static final Integer uid = 1;
//    public static final Integer shippingId = 7;
//    private Integer productId = 26;
//    @Resource
//    private ICartService cartService;
//
//    @Before
//    public void before() {
//        log.info("【新增购物车、、、】");
//        CartAddForm form = new CartAddForm();
//        form.setProductId(productId);
//        form.setSelected(true);
//        ResponseVo<CartVo> responseVo = cartService.add(uid, form);
//        log.info(" list = "+gson.toJson(responseVo));
//        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
//    }
////    @Test
//    public  ResponseVo<OrderVo> create() {
//        ResponseVo<OrderVo> orderVoResponseVo = orderService.create(uid, shippingId);
//        log.info("orderVoResponseVo = "+orderVoResponseVo);
//        return orderVoResponseVo;
////        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),orderVoResponseVo.getStatus());
//    }
//    @Test
//    public void list(){
//        ResponseVo<PageInfo> list = orderService.list(uid, 1, 7);
//        log.info("list = "+gson.toJson(list));
//    }
//
//    @Test
//    public void detail() {
//        ResponseVo<OrderVo> orderVoResponseVo = create();
//        ResponseVo<OrderVo> detail = orderService.detail(uid, orderVoResponseVo.getData().getOrderNo());
//        log.info("detail = "+gson.toJson(detail));
//    }
//
//    @Test
//    public void cancel() {
//        ResponseVo<OrderVo> orderVoResponseVo = create();
//        ResponseVo<OrderVo> cancel = orderService.cancel(uid, orderVoResponseVo.getData().getOrderNo());
//        log.info("cancel = "+gson.toJson(cancel));
//    }
//}