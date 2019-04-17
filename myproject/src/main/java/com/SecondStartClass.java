package com;

import com.test.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName SecondStartClass
 * @Description TODO
 * @Author dell
 * @Date 2019/4/15 14:48
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ServletComponentScan(value = "com.test.servlet.*")
public class SecondStartClass {
    public static void main(String[] args) {
        SpringApplication.run(SecondStartClass.class);
    }
    //要加次注解，否则，这个方法不运行。
    @Bean
    public ServletRegistrationBean getServletRegistration()
    {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new SecondServlet());//放入自己的servlet。
        servletRegistrationBean.addUrlMappings("/second/servlet");
        return servletRegistrationBean;
    }
    //第三种方式。
//    @Bean
//    public ServletRegistrationBean ServletRegistration()
//    {
//        return new ServletRegistrationBean(new SecondServlet(),"/three/servlet");
//    }
}
