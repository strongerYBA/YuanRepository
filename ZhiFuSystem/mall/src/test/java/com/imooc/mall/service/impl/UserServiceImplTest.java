//package com.imooc.mall.service.impl;
//
//import com.imooc.mall.MallApplicationTests;
//import com.imooc.mall.enums.RoleEnum;
//import com.imooc.mall.pojo.User;
//import com.imooc.mall.service.IUserService;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.Assert.*;
//@Transactional
//public class UserServiceImplTest extends MallApplicationTests {
//    @Autowired
//    private IUserService userService;
//
//    @Test
//    public void register() {
//        User user = new User("admin","456789",
//                "4567841232@qq.com", RoleEnum.CUSTOMER.getCode());
//        userService.register(user);
//    }
//}