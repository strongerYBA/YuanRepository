package com.hot.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HotDeployController
 * @Author Administrator
 * @Date 2019/4/14 19:14
 */
@Controller
public class HotDeployController {

    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String say(HttpServletRequest request)
    {
        request.setAttribute("say","hello everyone!!!，good morning everyone...");
        return "index";
    }
    @RequestMapping(value = "/redirect",method = RequestMethod.GET)
    public String redirectSay(HttpServletRequest request)
    {
        request.setAttribute("say","hello everyone!!!---->redirect");
        return "redirect/index";
    }
}
