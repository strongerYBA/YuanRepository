package yuanspringboot.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Before {@link org.springframework.boot.context.config.ConfigFileApplicationListener}实现。
 * @ClassName BeforeConfigFileApplicationListener
 * @Author Administrator
 * @Date 2019/4/21 18:21
 */
public class BeforeConfigFileApplicationListener implements SmartApplicationListener,  Ordered {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType) || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public int getOrder() {//比ConfigFileApplicationListener（-1）优先级更高。所以获取property文件信息。是获取不到的。（+1）就可以获取了。
        return ConfigFileApplicationListener.DEFAULT_ORDER-1;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent environmentPreparedEvent = (ApplicationEnvironmentPreparedEvent)event;
            ConfigurableEnvironment environment = environmentPreparedEvent.getEnvironment();
            System.out.println("environment.property = "+environment.getProperty("name"));
        }

        if (event instanceof ApplicationPreparedEvent) {
        }
    }
}
