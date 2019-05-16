package com.spirng.externalizated.configuration.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 扩展{@link org.springframework.context.annotation.PropertySource} {@link EnvironmentPostProcessor}实现
 * @ClassName ExtendPropertySourcesEnvironmentPostProcessor
 * @Author Administrator
 * @Date 2019/5/16 22:10
 */
public class ExtendPropertySourcesEnvironmentPostProcessor implements EnvironmentPostProcessor , Ordered {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String,Object> source = new HashMap<>();
        //1.from-environmentPrepared  user.id  = 0
        //2.from-applicationEnvironmentPreparedEvent = 9
        //3.from-EnvironmentPostProcessor =19
        //application.properties/user.id=3
        //META-INF/default.properties.  /user.id=7

        source.put("user.id","19");

        MapPropertySource propertySource = new MapPropertySource("from-EnvironmentPostProcessor",source);
        propertySources.addFirst(propertySource);
    }

    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER-1;
    }
}
