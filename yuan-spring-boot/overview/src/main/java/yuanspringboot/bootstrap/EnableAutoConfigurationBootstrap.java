package yuanspringboot.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link EnableAutoConfiguration} 引导类。
 * @ClassName EnableAutoConfigurationBootstrap
 * @Author Administrator
 * @Date 2019/4/20 23:19
 */
@EnableAutoConfiguration
//@SpringBootApplication
public class EnableAutoConfigurationBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap  .class)
                .web(WebApplicationType.NONE)//非web类型。
                .run(args);
        String helloworld = context.getBean("helloworld",String.class);
        System.out.println("helloworld这个Bean = "+helloworld);
        context.close();

    }
}
