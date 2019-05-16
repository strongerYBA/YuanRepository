package yuanspringboot.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Hello World {@link SpringApplicationRunListener}springboot监听器。
 * @ClassName HelloWorldRunListener
 * @Author Administrator
 * @Date 2019/4/21 17:28
 */
public class HelloWorldRunListener implements SpringApplicationRunListener {
    public HelloWorldRunListener(SpringApplication application, String[] args)
    {

    }
    @Override
    public void starting() {
        System.out.println("HelloWorldRunListener starting ... ");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
