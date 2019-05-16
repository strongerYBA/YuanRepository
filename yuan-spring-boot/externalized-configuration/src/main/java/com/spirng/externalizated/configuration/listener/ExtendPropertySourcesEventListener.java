package com.spirng.externalizated.configuration.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 扩展{@link org.springframework.context.annotation.PropertySource}{@link org.springframework.context.ApplicationListener}
 * 实现 ， 监听{@link org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent}
 * @ClassName ExtendPropertySourcesEventListener
 * @Author Administrator
 * @Date 2019/5/16 21:26
 */
public class ExtendPropertySourcesEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        ConfigurableEnvironment environment = applicationEnvironmentPreparedEvent.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String,Object> source = new HashMap<>();
        //1.from-environmentPrepared  user.id  = 0
        //2.from-applicationEnvironmentPreparedEvent
        //application.properties/user.id=3
        //META-INF/default.properties.  /user.id=7

        source.put("user.id","9");

        MapPropertySource propertySource = new MapPropertySource("from-applicationEnvironmentPreparedEvent",source);
        propertySources.addFirst(propertySource);
    }
}
