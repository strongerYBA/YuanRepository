package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName FirstServlet
 * @Description TODO
 * @Author dell
 * @Date 2019/4/15 14:05
 */
@WebServlet(name = "first servlet",urlPatterns = "/first/servlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.getWriter().println("my first servlet test !!!");
    }
}
