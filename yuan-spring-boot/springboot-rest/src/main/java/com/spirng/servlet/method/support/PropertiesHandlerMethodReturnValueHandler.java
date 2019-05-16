package com.spirng.servlet.method.support;

import com.spirng.servlet.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * {@link org.springframework.web.method.support.HandlerMethodReturnValueHandler}{@link java.util.Properties}的实现。
 * @ClassName PropertiesHandlerMethodReturnValueHandler
 * @Author Administrator
 * @Date 2019/5/4 23:53
 */
public class PropertiesHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {
    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        //判断方法的返回值是否与Properties类型匹配。
        return Properties.class.equals(methodParameter.getMethod().getReturnType());
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
      //强制转换。
        Properties properties = (Properties)o;
        //复用。
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();
        ServletWebRequest servletWebRequest = (ServletWebRequest)nativeWebRequest;
        //Servlet Request Api 实现。
        HttpServletRequest httpServletRequest = servletWebRequest.getRequest();
        String content_Type=httpServletRequest.getHeader("Content-Type");
        //获取Content-Type请求头中的媒体类型。
        MediaType mediaType = MediaType.parseMediaType(content_Type);
        //获取Servlet Response API.对象。
        HttpServletResponse httpServletResponse = servletWebRequest.getResponse();
        HttpOutputMessage message = new ServletServerHttpResponse(httpServletResponse);
        //通过PropertiesHttpMessageConverter进行输出。
        converter.write(properties,mediaType,message);

        //告知SpringMVC当前请求处理已经完毕。避免控制台出错。
        modelAndViewContainer.setRequestHandled(true);
    }
}
