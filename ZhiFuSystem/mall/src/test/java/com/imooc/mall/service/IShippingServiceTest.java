//package com.imooc.mall.service;
//
//import com.github.pagehelper.PageInfo;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.imooc.mall.MallApplicationTests;
//import com.imooc.mall.enums.ResponseEnum;
//import com.imooc.mall.form.ShippingForm;
//import com.imooc.mall.vo.ResponseVo;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
//import org.junit.Test;
//
//import javax.annotation.Resource;
//
//import java.util.Map;
//
//import static org.junit.Assert.*;
//@Slf4j
//public class IShippingServiceTest extends MallApplicationTests {
//    @Resource
//    private IShippingService shippingService;
//    private Integer uid = 1;
//    @Resource
//    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    @Test
//    public void add() {
//        ShippingForm form = new ShippingForm(
//                "yuan",
//                "18394568574",
//                "45678963521",
//                "陕西",
//                "西安",
//                "725001",
//                "安康市，汉滨区",
//                "000000");
//        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(1, form);
//        log.info("add = {}",responseVo);
//        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
//    }
//
//    @Test
//    public void delete() {
//        ResponseVo responseVo = shippingService.delete(1, 6);
//        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
//    }
//
//    @Test
//    public void update() {
//        ShippingForm form = new ShippingForm(
//                "admin",
//                "18394568574",
//                "45678963521",
//                "陕西",
//                "西安",
//                "725001",
//                "安康市，汉滨区",
//                "000000");
//        ResponseVo<Map<String, Integer>> responseVo = shippingService.update(1, 7,form);
//        log.info("add = {}",responseVo);
//        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
//    }
//
//    @Test
//    public void list() {
//        ResponseVo<PageInfo> responseVo = shippingService.list(1, 1, 10);
//        log.info("add = "+gson.toJson(responseVo));
//        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
//    }
//}