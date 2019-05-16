package com.spirng.servlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HelloWorld{@link Controller}
 * @ClassName HelloWorldController
 * @Author Administrator
 * @Date 2019/5/5 22:26
 */
@Controller
public class HelloWorldController {
    @RequestMapping("")
    public String index()
    {

        return "index";
    }

}
