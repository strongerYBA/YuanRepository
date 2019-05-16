package com.spirng.servlet.controller;

import com.spirng.servlet.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User {@link RestController}
 * @ClassName UserRestController
 * @Author Administrator
 * @Date 2019/5/3 10:21
 */
@RestController
public class UserRestController {
    @PostMapping(value = "/echo/user",
            consumes = "application/json;charset=UTF-8",//输入参数。
            produces = "application/json;charset=UTF-8")//输出参数。
    public User user(@RequestBody User user)
    {
            return user;
    }
}
