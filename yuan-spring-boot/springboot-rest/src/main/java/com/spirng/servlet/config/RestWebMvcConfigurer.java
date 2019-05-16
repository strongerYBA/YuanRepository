package com.spirng.servlet.config;

import com.spirng.servlet.method.support.PropertiesHandlerMethodArgumentResolver;
import com.spirng.servlet.method.support.PropertiesHandlerMethodReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Rest {@link WebMvcConfigurer}实现。
 * @ClassName RestWebMvcConfigurer
 * @Author Administrator
 * @Date 2019/5/3 11:33
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {
  @Autowired
  private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
  @PostConstruct
    public void init()
    {
        //获取当前RequestMappingHandlerAdapter所有的Resolver对象。
        List<HandlerMethodArgumentResolver> list = requestMappingHandlerAdapter.getArgumentResolvers();
        List<HandlerMethodArgumentResolver> newResolver =  new ArrayList<>(list.size()+1);
        //添加。PropertiesHandlerMethodArgumentResolver到集合首位。
        newResolver.add(new PropertiesHandlerMethodArgumentResolver());
        //添加已注册的Resolver对象。
        newResolver.addAll(list);
        //重新设置Resolver对象。
        requestMappingHandlerAdapter.setArgumentResolvers(newResolver);
        //获取当前HandlerMethodReturnValueHandler所有的Handler对象。
        List<HandlerMethodReturnValueHandler> handlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newHanlers = new ArrayList<>(handlers.size()+1);
        //添加。PropertiesHandlerMethodReturnValueHandler到集合首位。
        newHanlers.add(new PropertiesHandlerMethodReturnValueHandler());
        //添加已注册的Resolver对象。
        newHanlers.addAll(handlers);
        //重新设置Resolver对象。
        requestMappingHandlerAdapter.setReturnValueHandlers(newHanlers);

     }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        //添加。PropertiesHandlerMethodArgumentResolver到集合首位。


//        if (resolvers.isEmpty())
//        {
//            resolvers.add(new PropertiesHandlerMethodArgumentResolver());
//
//        }
//        else
//        {
//            resolvers.set(0,new PropertiesHandlerMethodArgumentResolver());
//
//        }
        //添加自定義HandlerMethodArgumentResolver优先级低于HandlerMethodArgumentResolver内建。

    }
    @Override
   public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    //不建议添加到Converters的末尾。
//    converters.add(new PropertiesHttpMessageConverter());
//    converters.set(0,new PropertiesHttpMessageConverter());//添加至集合首位。写出，需要排序。

    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {//通过配置的方式实现跨域请求。

      registry.addMapping("/**").allowedOrigins("*");
    }
}
