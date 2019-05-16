package com.spirng.servlet.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Spring mvc 配置类。
 * @ClassName WebMvcConfig
 * @Author Administrator
 * @Date 2019/4/21 23:04
 */
@Configuration//注解配置。
public class WebMvcConfig {

    @Bean
    public ViewResolver myViewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        //ThymeleafViewResolver ordered.lowest_precedence-5.

        viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE-10);//倒数第十一位。高于thymeleafviewresolver。
        //配置viewResolver的content-type媒体类型。
        viewResolver.setContentType("text/xml;charset=UTF-8");
        return viewResolver;
    }
//    @Override
    public   void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)//是否偏好于参数。
       .favorPathExtension(true);
    }
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer()
    {
        return (factory)->{
            factory.addContextCustomizers(context -> {
                //user.dir = D:\spring_boot\yuan-spring-boot相对路径。
                String relativePath = "D:\\spring_boot\\yuan-spring-boot\\springboot-view\\src\\main\\webapp";
                File baseFile = new File(relativePath);
                if (baseFile.exists())
                {
                    context.setDocBase(baseFile.getAbsolutePath());//解决maven多模块jsp 无法读取的问题。
                }
            });
        };
    }
    public void  addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
               System.out.println("拦截中！！！！ ..." );
                return true;
            }
        });
    }
}
