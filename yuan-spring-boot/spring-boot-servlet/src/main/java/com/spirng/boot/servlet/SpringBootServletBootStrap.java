package com.spirng.boot.servlet;

import com.spirng.AsyncServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * SpringBootServletBootStrap 引导类。
 * @ClassName SpringBootServletBootStrap
 * @Author Administrator
 * @Date 2019/5/7 22:45
 */
@EnableAutoConfiguration
//@ServletComponentScan(basePackages = "com.spirng")
public class SpringBootServletBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootServletBootStrap.class,args);
    }
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ServletRegistrationBean asyncServletServletRegistrationBean()
    {
        ServletRegistrationBean bean =
                new ServletRegistrationBean(new AsyncServlet(),"/");
        bean.setName("MyAsyncServlet");
        return bean;
    }
    @Bean
    public ServletContextInitializer servletContextInitializer()
    {
            return servletContext -> {
                CharacterEncodingFilter filter = new CharacterEncodingFilter();
                FilterRegistration.Dynamic  registration= servletContext.addFilter("filter", filter);
                registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),false,"/");
            };
    }
}
