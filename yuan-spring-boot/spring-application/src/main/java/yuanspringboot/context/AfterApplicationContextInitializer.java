package yuanspringboot.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @ClassName AfterApplicationContextInitializer
 * @Author Administrator
 * @Date 2019/4/21 11:20
 */
//@Order(Ordered.LOWEST_PRECEDENCE)//默认最低优先级。或者实现Ordered也行。
public class AfterApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C> , Ordered{
    @Override
    public void initialize(C c) {
        System.out.println("AfterApplicationContextInitializer.id = "+c.getId());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
