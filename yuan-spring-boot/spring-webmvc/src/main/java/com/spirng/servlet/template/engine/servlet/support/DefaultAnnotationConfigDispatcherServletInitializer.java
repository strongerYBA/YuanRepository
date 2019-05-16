//package com.spirng.servlet.servlet.support;
//
//import DispatcherServletConfiguration;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
///**
// * Spring Web MVC 自动装配，默认实现。
// * 默认实现{@link AbstractAnnotationConfigDispatcherServletInitializer}
// * @ClassName DefaultAnnotationConfigDispatcherServletInitializer
// * @Author Administrator
// * @Date 2019/4/23 21:57
// */
//public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//    @Override
//    protected Class<?>[] getRootConfigClasses() {//web.xml.中init-param.
//        return new Class[0];
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {//DispatcherServlet
//        return new Class[]{DispatcherServletConfiguration.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {//映射。
//        return new String[]{"/"};
//    }
//}
