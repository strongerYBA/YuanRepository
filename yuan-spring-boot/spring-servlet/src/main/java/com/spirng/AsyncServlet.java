package com.spirng;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static javax.servlet.http.HttpServletResponse.SC_SERVICE_UNAVAILABLE;

/**
 * 异步 Servlet。
 * @ClassName AsyncServlet
 * @Author Administrator
 * @Date 2019/5/7 21:14
 */
@WebServlet(
        asyncSupported = true,//激活异步特性。
        name = "asyncServlet",//servlet名字。
            urlPatterns = "/sync-servlet"
)
public class AsyncServlet extends HttpServlet    {
    //覆盖service。
    @Override
    public void service(HttpServletRequest  request, HttpServletResponse response) throws IOException , ServletException
    {
        //判断是否支持异步。
        if(request.isAsyncSupported())
        {
            //创建AyncContext。异步上下文。
            AsyncContext asyncContext = request.startAsync();
            //设置超时时间
            asyncContext.setTimeout(50L);
            //创建监听器。
            asyncContext.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent asyncEvent) throws IOException {
                    println("执行完成");
                }

                @Override
                public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                    HttpServletResponse suppliedResponse = (HttpServletResponse)asyncEvent.getSuppliedResponse();
                    suppliedResponse.setStatus(SC_SERVICE_UNAVAILABLE);
                    println("执行超时");
                }

                @Override
                public void onError(AsyncEvent asyncEvent) throws IOException {
                    println("执行错误");
                }

                @Override
                public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                    println("开始执行");
                }
            });
            println("hello ,world start ...");
//            ServletResponse servletResponse = asyncContext.getResponse();
//            //设置响应媒体类型。
//            servletResponse.setContentType("text/plain;charset=UTF-8");
//            //获取字符输出流。
//            PrintWriter printWriter = servletResponse.getWriter();
//            printWriter.println("hello ,world ...");
//            printWriter.flush();
        }
    }
    private static  void println(Object object)
    {
        String threadName = Thread.currentThread().getName();
        System.out.println("AsyncServlet["+threadName+"]:"+object);
    }
}
