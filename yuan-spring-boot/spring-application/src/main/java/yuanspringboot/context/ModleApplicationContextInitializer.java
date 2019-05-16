package yuanspringboot.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * @ClassName ModleApplicationContextInitializer
 * @Author Administrator
 * @Date 2019/4/21 11:29
 */
public class ModleApplicationContextInitializer implements ApplicationContextInitializer, Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ModleApplicationContextInitializer.id = "+configurableApplicationContext.getId());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
