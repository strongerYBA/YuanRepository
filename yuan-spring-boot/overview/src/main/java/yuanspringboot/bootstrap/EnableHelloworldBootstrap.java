package yuanspringboot.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import yuanspringboot.annotation.EnableHelloworld;

/**
 * {@link EnableHelloworld}  引导类。
 * @ClassName EnableHelloworldBootstrap
 * @Author Administrator
 * @Date 2019/4/18 20:30
 */
@EnableHelloworld
public class EnableHelloworldBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloworldBootstrap.class)
                .web(WebApplicationType.NONE)//非web类型。
                .run(args);
        //MyFirstLevelRepository这个Bean是否存在。//派生性。
        String helloworld = context.getBean("helloworld",String.class);
        System.out.println("helloworld这个Bean = "+helloworld);
        context.close();//关闭上下文。
    }
}
