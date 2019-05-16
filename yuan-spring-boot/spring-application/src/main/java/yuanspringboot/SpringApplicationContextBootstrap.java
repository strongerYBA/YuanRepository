package yuanspringboot;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * Spring应用上下文引导类。
 * @ClassName SpringApplicationContextBootstrap
 * @Author Administrator
 * @Date 2019/4/21 18:38
 */
@SpringBootApplication
public class SpringApplicationContextBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
//                .web(WebApplicationType.NONE)
                .run(args);
        System.out.println("ConfigurableApplicationContext 的类型："+context.getClass().getName());
        System.out.println("Environment 的类型："+context.getEnvironment().getClass().getName());
        context.close();
    }
}
