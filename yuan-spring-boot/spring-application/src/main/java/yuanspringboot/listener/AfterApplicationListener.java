package yuanspringboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

/**
 * After Hello World {@link ApplicationListener}监听{@link ContextRefreshedEvent}
 * @ClassName AfterApplicationListener
 * @Author Administrator
 * @Date 2019/4/21 11:45
 */

public class AfterApplicationListener implements ApplicationListener<ContextRefreshedEvent>, Ordered {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        System.out.println( "After helloworld : "+event.getApplicationContext().getId()+", timestamp : "+event.getTimestamp());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
