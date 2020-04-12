package com.imooc.mall.config;

import com.imooc.mall.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName InterceptorConfig
 * @Author Administrator
 * @Date 2020/3/10 14:23
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器。
        registry.addInterceptor(new UserLoginInterceptor())
                .addPathPatterns("/**")//默认对所用url进行拦截。
                .excludePathPatterns(
//                        "/user/login",
                        "/user/register",
                        "/category",
                        "/products",
                        "/products/*",
                        "/carts",
                        "/error");//对登录和注册不拦截。
    }
}
