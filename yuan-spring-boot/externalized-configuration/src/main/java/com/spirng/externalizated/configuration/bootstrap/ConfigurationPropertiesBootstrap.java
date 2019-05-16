package com.spirng.externalizated.configuration.bootstrap;

import com.spirng.externalizated.configuration.domain.User;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

/**
 * {@link org.springframework.boot.context.properties.ConfigurationProperties ConfigurationProperties}
 * 注解。
 * @ClassName ConfigurationPropertiesBootstrap
 * @Author Administrator
 * @Date 2019/5/14 22:51
 */
@EnableAutoConfiguration
//@EnableConfigurationProperties(User.class)
public class ConfigurationPropertiesBootstrap {

    @Bean
    @ConfigurationProperties(prefix = "user")
    @ConditionalOnProperty(prefix = "user.",name = "city.post-code",matchIfMissing = false ,havingValue = "001")
    public User user()
    {
        return new User();
    }
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConfigurationPropertiesBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
//        User user = context.getBean("user", User.class);
        User user = context.getBean( User.class);
        System.err.println("用户对象："+user);
        context.close();

    }
}
