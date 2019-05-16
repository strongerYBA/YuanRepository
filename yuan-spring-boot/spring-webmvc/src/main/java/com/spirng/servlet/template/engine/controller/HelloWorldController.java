package com.spirng.servlet.template.engine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Hello World {@link Controller}
 * @ClassName HelloWorldController
 * @Author Administrator
 * @Date 2019/4/21 19:34
 */
@Controller
public class HelloWorldController {
    @RequestMapping("")
    public String index(
            @RequestParam int id, @CookieValue("JSESSIONID") String jsessionId,
                        Model model)
    {

        model.addAttribute("jsessionId",jsessionId);
        model.addAttribute("message","hello controller !!!");
        return "index";
    }
//    @ModelAttribute("message")
//    public String hello()
//    {
//        return "hello controller !!!";
//    }
//    @ModelAttribute("acceptLanguage")
//    public String acceptLanguages(@RequestHeader("Accept-Language") String acceptLanguage)
//    {
//        return acceptLanguage;
//    }
}
