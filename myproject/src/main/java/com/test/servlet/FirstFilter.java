package com.test.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 第一中过滤器filter。
 * @ClassName FirstFilter
 * @Description TODO
 * @Author dell
 * @Date 2019/4/17 14:50
 */
@WebFilter(filterName = "first filter",urlPatterns = "/first/*")
public class FirstFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入first filter ...");
        System.out.println(request);
        chain.doFilter(request,response);
        System.out.println("走出first filter ...");
    }
}
