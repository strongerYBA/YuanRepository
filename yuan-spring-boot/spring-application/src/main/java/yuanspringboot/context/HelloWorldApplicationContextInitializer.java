package yuanspringboot.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @ClassName HelloWorldApplicationContextInitializer
 * @Author Administrator
 * @Date 2019/4/21 11:16
 */
@Order(Ordered.HIGHEST_PRECEDENCE)//添加为最高优先级，默认是最低优先级。
public class HelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C> {
    @Override
    public void initialize(C configurableApplicationContext) {
        System.out.println("ConfigurableApplicationContext.id = "+configurableApplicationContext.getId());

    }
}
