package com.spirng.servlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * User {@link RestController}{@link java.util.Properties}
 * @ClassName UserRestController
 * @Author Administrator
 * @Date 2019/5/3 10:21
 */
//@RestController
@Controller
public class PropertiesRestController {
    @PostMapping(value = "/add/properties",
            consumes = "text/properties;charset=UTF-8" //过滤媒体类型。
//            produces = "application/json;charset=UTF-8"
    )//输出参数。
    public Properties  addProperties(
//            @RequestBody
                    Properties properties)
    {
        return properties;
    }
}


