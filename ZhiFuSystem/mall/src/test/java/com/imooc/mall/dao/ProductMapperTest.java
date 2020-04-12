//package com.imooc.mall.dao;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.imooc.mall.MallApplicationTests;
//import com.imooc.mall.pojo.Product;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//
//import javax.annotation.Resource;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//@Slf4j
//public class ProductMapperTest extends MallApplicationTests {
//    @Resource
//    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
//    @Resource
//    private ProductMapper productMapper;
//    @Test
//    public void productTest() {
//        Map<String,Object> map =new HashMap<>();
////        map.put("type","top10");
//        map.put("type","bottom10");
//        List<Product> top10 = productMapper.productTest(map);
//        log.info("List<Product> = "+gson.toJson(top10));
//    }
//}