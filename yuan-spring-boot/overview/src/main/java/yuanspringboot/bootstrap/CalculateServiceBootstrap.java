package yuanspringboot.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import yuanspringboot.service.CalculateService;

/**
 * {@link CalculateService} 引导类。
 * @ClassName CalculateServiceBootstrap
 * @Author Administrator
 * @Date 2019/4/18 21:31
 */
@SpringBootApplication(scanBasePackages = "yuanspringboot.service")
public class CalculateServiceBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .web(WebApplicationType.NONE)//非web类型。
                .profiles("java8")//采用条件装配。
                .run(args);
        //MyFirstLevelRepository这个Bean是否存在。//派生性。
        CalculateService calculateService = context.getBean(CalculateService.class);
        System.out.println("calculateService.sum(1...10)= "+calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        context.close();//关闭上下文。
    }
}
