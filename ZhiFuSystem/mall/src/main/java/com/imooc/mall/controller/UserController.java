package com.imooc.mall.controller;

import com.imooc.mall.consts.MallConst;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.UserRegisterForm;
import com.imooc.mall.form.UserLoginForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

/**
 * @ClassName UserController
 * @Author Administrator
 * @Date 2020/3/9 11:49
 */
@RestController
@Slf4j
public class UserController {
    @Resource
    private IUserService userService;
    @PostMapping("/user/register")
    public ResponseVo register(@Valid @RequestBody UserRegisterForm userForm){
        log.info("username={}",userForm.getUsername());
        User user = new User();
        BeanUtils.copyProperties(userForm,user);
        return userService.register(user);
    }
    @PostMapping("/user/login")
    @ResponseBody
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                                  HttpSession session){
        ResponseVo<User> login = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        //设置session。
        session.setAttribute(MallConst.CURRENT_USER,login.getData());
        log.info("/login session id = {}",session.getId());
        return login;
    }

    /**
     * session保存在内存里，缺点：容易丢失，服务器启动，电脑重启，都会丢失。
     * 如何解决：可以换一种存储方式。如mysql。改进版本token+redis等。其实token就是session也就是cookie。
     * @param session
     * @return
     */
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session){
        log.info("/user session id = {}",session.getId());
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success(user);
    }

    /**
     * 登出功能。
     * @param session
     * @return
     */
    //TODO 判断登录状态。拦截器实现。
    @PostMapping("/user/logout")
    /**
     * {@link org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory}
     */
    public ResponseVo logout(HttpSession session){
        log.info("/logout session id = {}",session.getId());
        //判断是否是登录状态。

        //移除。
        session.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success();
    }
}
