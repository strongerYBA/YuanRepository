package com.spirng.servlet.method.support;

import com.spirng.servlet.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

/**
 * {@link java.util.Properties 类型}{@link   org.springframework.web.method.support.HandlerMethodArgumentResolver}
 * @ClassName PropertiesHandlerMethodArgumentResolver
 * @Author Administrator
 * @Date 2019/5/4 22:04
 */
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {

        return Properties.class.equals(methodParameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        //复用。
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();


        ServletWebRequest servletWebRequest = (ServletWebRequest)nativeWebRequest;
        //Servlet Request Api 实现。
        HttpServletRequest httpServletRequest = servletWebRequest.getRequest();


        HttpInputMessage message = new ServletServerHttpRequest(httpServletRequest);

        Properties properties = converter.read(null,null,message);
//        String content_Type=httpServletRequest.getHeader("Content-Type");
//        //获取Content-Type请求头中的媒体类型。
//        MediaType mediaType = MediaType.parseMediaType(content_Type);
//
//        Charset charset = mediaType.getCharset();
//
//        charset = charset==null?Charset.forName("UTF-8"):charset;
//        //请求输入字节流。
//        InputStream inputStream = httpServletRequest.getInputStream();
//
//        InputStreamReader reader = new InputStreamReader(inputStream,charset);
//
//        Properties properties = new Properties();
//        //加载字符流。成为properties对象。
//        properties.load(reader);
//


        return properties;
    }
}
