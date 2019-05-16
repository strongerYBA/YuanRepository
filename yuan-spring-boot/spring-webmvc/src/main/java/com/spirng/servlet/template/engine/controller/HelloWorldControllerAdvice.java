package com.spirng.servlet.template.engine.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * {@link HelloWorldController}通知。
 * @ClassName HelloWorldControllerAdvice
 * @Author Administrator
 * @Date 2019/4/22 22:12
 */
@ControllerAdvice(assignableTypes = HelloWorldController.class)//只处理HelloWorldController这个controller。
public class HelloWorldControllerAdvice {
    @ModelAttribute("message")
    public String hello()
    {
        return "hello controller !!!";
    }
    @ModelAttribute("acceptLanguage")
    public String acceptLanguages(@RequestHeader("Accept-Language") String acceptLanguage)
    {
        return acceptLanguage;
    }
//    @ExceptionHandler(Throwable.class)
//    public ResponseEntity<String> onException(Throwable throwable)//处理异常。
//    {
//        return ResponseEntity.ok(throwable.getMessage());
//    }
}
