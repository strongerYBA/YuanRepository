package com.spirng.externalizated.configuration.bootstrap;

import com.spirng.externalizated.configuration.domain.User;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName XmlPlaceholderExternalizedConfigurationBootstrap
 * @Author Administrator
 * @Date 2019/5/14 21:19
 */
@ImportResource("META-INF/spring/user-context.xml")//加载spring上下文
@EnableAutoConfiguration
public class XmlPlaceholderExternalizedConfigurationBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(XmlPlaceholderExternalizedConfigurationBootstrap.class)
                        .web(WebApplicationType.NONE)
                        .run(args);
        User user = context.getBean("user", User.class);
        System.err.println("用户对象："+user);
        System.err.printf("System.getProperty(\"%s\"):%s\n","user.name",System.getProperty("user.name"));
        //关闭上下文
        context.close();
    }
}
