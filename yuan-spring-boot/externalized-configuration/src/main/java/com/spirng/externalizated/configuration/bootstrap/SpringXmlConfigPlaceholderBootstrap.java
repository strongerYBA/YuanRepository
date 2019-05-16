package com.spirng.externalizated.configuration.bootstrap;

import com.spirng.externalizated.configuration.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring XML 站位符引导类。
 * @ClassName SpringXmlConfigPlaceholderBootstrap
 * @Author Administrator
 * @Date 2019/5/14 21:05
 */
public class SpringXmlConfigPlaceholderBootstrap {
    public static void main(String[] args) {
        String[] locations =  {"META-INF/spring/spring-context.xml","META-INF/spring/user-context.xml"};
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(locations);
        User user = applicationContext.getBean("user",User.class);
        System.err.println("用户对象："+user);
        System.err.printf("System.getProperty(\"%s\"):%s\n","user.name",System.getProperty("user.name"));
        //关闭上下文
        applicationContext.close();
    }
}

