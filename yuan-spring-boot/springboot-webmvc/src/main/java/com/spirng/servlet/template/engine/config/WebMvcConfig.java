package com.spirng.servlet.template.engine.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring mvc 配置类。
 * @ClassName WebMvcConfig
 * @Author Administrator
 * @Date 2019/4/21 23:04
 */
@Configuration//注解配置。
//@EnableWebMvc//激活注解。
public class WebMvcConfig {

//    <!--    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">-->
//<!--    <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>-->
//<!--    <property name="prefix" value="/WEB-INF/jsp/"/>-->
//<!--        <property name="suffix" value=".jsp"/>-->
//<!--    </bean>-->
//    @Bean
//    public ViewResolver viewResolver()
//    {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/jsp/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

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
