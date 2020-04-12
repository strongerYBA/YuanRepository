//package com.imooc.mall.controller;
//
//import com.imooc.mall.MallApplicationTests;
//import com.imooc.mall.enums.ResponseEnum;
//import com.imooc.mall.enums.RoleEnum;
//import com.imooc.mall.pojo.User;
//import com.imooc.mall.service.IUserService;
//import com.imooc.mall.vo.ResponseVo;
//import org.apache.ibatis.annotations.Param;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.Assert.*;
//
//public class UserControllerTest extends MallApplicationTests {
//    @Autowired
//    private IUserService userService;
//    public static final String USERNAME="cc";
//    public static final String PASSWORD = "cc";
//    public static final String EMAIL = "cc@qq.com";
//
//    @Before
//    public void register() {
//        User user = new User(USERNAME, PASSWORD,
//                EMAIL, RoleEnum.CUSTOMER.getCode());
//        userService.register(user);
//    }
//
//    @Test
//    public void login() {
//        ResponseVo login = userService.login(USERNAME, PASSWORD);
//        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),login.getStatus());
//    }
//
//    @Test
//    public void userInfo() {
//    }
//
//    @Test
//    public void logout() {
//    }
//}