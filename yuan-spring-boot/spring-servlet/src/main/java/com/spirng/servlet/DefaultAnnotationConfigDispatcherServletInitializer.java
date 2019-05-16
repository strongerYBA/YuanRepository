package com.spirng.servlet;//package com.spirng.servlet.servlet.support;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring Web MVC 自动装配，默认实现。
 * 默认实现{@link AbstractAnnotationConfigDispatcherServletInitializer}
 * @ClassName DefaultAnnotationConfigDispatcherServletInitializer
 * @Author Administrator
 * @Date 2019/4/23 21:57
 */
@ComponentScan(basePackages = "com.spirng.controller")
@Configuration
public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {//web.xml.中init-param.
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//DispatcherServlet
        return new Class[]{getClass()};//返回当前类。
    }

    @Override
    protected String[] getServletMappings() {//映射。
        return new String[]{"/"};
    }
}
