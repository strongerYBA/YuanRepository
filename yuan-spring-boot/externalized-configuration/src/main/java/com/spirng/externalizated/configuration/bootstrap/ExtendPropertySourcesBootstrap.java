package com.spirng.externalizated.configuration.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Locale;

/**
 * {@link org.springframework.core.env.PropertySource} 引导类。
 * @ClassName ExtendPropertySourcesBootstrap
 * @Author Administrator
 * @Date 2019/5/16 21:09
 */
@EnableAutoConfiguration
@Configuration
@PropertySource(name = "from classpath:META-INF/default.properties",value = "classpath:META-INF/default.properties")
public class ExtendPropertySourcesBootstrap {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ExtendPropertySourcesBootstrap.class)
                .web(WebApplicationType.NONE)
                .properties("user.id=99")//Default properties
                .run(of("--user.id=88"));//Command line arguments

        //获取Environment
        ConfigurableEnvironment environment = context.getEnvironment();
        System.err.printf("用户id：%d\n",environment.getProperty("user.id",Long.class));

        environment.getPropertySources().forEach(propertySource -> {
            System.out.printf("PropertySource[名称：%s]\n",propertySource.getName(),propertySource);
            System.out.println();
        });
        context.close();
    }
    private static <T> T[] of(T... args)
    {
            return args;
    }
}
