package com.spirng.servlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HelloWorldController
 * @Author Administrator
 * @Date 2019/4/25 22:36
 */
@Controller
public class HelloWorldController {
    @GetMapping("/hello-world")
    public  String helloWorld()
    {
        return "hello-world";//view 逻辑名称。
    }
    @ModelAttribute("message")
    public String message()
    {
        return "hello world ....";
    }
    @RequestMapping("")
    public String index()
    {

        return "index";
    }
//    @Bean
//    @ConditionalOnMissingBean
//    public InternalResourceViewResolver defaultViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix(this.mvcProperties.getView().getPrefix());
//        resolver.setSuffix(this.mvcProperties.getView().getSuffix());
//        return resolver;
//    }
}
