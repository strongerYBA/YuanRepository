package com.imooc.mall.interceptor;

import com.imooc.mall.consts.MallConst;
import com.imooc.mall.exception.UserLoginException;
import com.imooc.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName UserLoginInterceptor
 * @Author Administrator
 * @Date 2020/3/10 14:17
 */
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {
    /**
     * return true 继续流程。false，中断。
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("UserLoginInterceptor preHandle ...");
        HttpSession session = request.getSession();
        String language = request.getHeader("language");
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        if (user == null){
            log.info("user = null");//中断不继续。
//            response.getWriter().print("error")
            throw new UserLoginException(language);
        }
        return true;
    }
}
