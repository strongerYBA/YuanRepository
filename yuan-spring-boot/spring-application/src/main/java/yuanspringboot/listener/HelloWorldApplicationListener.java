package yuanspringboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Hello World {@link ApplicationListener}监听{@link ContextRefreshedEvent}
 * @ClassName HelloWorldApplicationListener
 * @Author Administrator
 * @Date 2019/4/21 11:41
 */
@Order(Ordered.HIGHEST_PRECEDENCE)//最高优先级。
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println( "helloworld : "+event.getApplicationContext().getId()+", timestamp : "+event.getTimestamp());

    }
}
