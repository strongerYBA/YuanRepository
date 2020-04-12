//package com.imooc.mall.service;
//
//import com.imooc.mall.MallApplicationTests;
//import com.imooc.mall.enums.ResponseEnum;
//import com.imooc.mall.vo.CategoryVo;
//import com.imooc.mall.vo.ResponseVo;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import static org.junit.Assert.*;
//@Slf4j
//public class ICategoryServiceTest extends MallApplicationTests {
//    @Autowired
//    private ICategoryService categoryService;
//
//    @Test
//    public void selectAll() {
//        ResponseVo<List<CategoryVo>> listResponseVo = categoryService.selectAll();
//        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),listResponseVo.getStatus());
//    }
//
//    @Test
//    public void findCategoryId() {
//        Set<Integer> set = new HashSet<>();
//        categoryService.findCategoryId(100001,set);
//        log.info(" set = "+set);
//    }
//}