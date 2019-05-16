package com.spirng.servlet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldRestController {@link RestController}实现。
 * @ClassName HelloWorldRestController
 * @Author Administrator
 * @Date 2019/5/3 9:35
 */
@RestController
public class HelloWorldRestController {
    @GetMapping(
            value = "/hello-world")
    public  String helloWorld(@RequestParam(required = false) String message)
    {
        return "hello,world ...."+message;
    }
//    @CrossOrigin("*")//“*”表示所有的请求都可以访问到此路径。
    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }
}
