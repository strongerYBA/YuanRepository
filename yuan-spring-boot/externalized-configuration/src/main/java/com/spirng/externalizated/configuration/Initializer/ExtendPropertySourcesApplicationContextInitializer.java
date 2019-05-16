package com.spirng.externalizated.configuration.Initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 扩展{@link org.springframework.context.annotation.PropertySource}{@link ApplicationContextInitializer}实现。
 * @ClassName ExtendPropertySourcesApplicationContextInitializer
 * @Author Administrator
 * @Date 2019/5/16 22:22
 */
public class ExtendPropertySourcesApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String,Object> source = new HashMap<>();
        //1.from-ApplicationContextInitializer = 29
        //2.from-environmentPrepared  user.id  = 0
        //3.from-applicationEnvironmentPreparedEvent
        //4.from-EnvironmentPostProcessor =19
        //application.properties/user.id=3
        //META-INF/default.properties.  /user.id=7

        source.put("user.id","29");

        MapPropertySource propertySource = new MapPropertySource("from-ApplicationContextInitializer",source);
        propertySources.addFirst(propertySource);
    }
}
