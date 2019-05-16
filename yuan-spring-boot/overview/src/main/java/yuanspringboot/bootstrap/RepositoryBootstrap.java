package yuanspringboot.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import yuanspringboot.repository.MyFirstLevelRepository;

/**
 * 仓储的引导类。
 * @ClassName RepositoryBootstrap
 * @Author Administrator
 * @Date 2019/4/17 21:52
 */
@ComponentScan(value = "com.spring.yuanspringboot.repository")
public class RepositoryBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)//非web类型。
                .run(args);
        //MyFirstLevelRepository这个Bean是否存在。//派生性。
        MyFirstLevelRepository myFirstLevelRepository = context.getBean("myFirstLevelRepository",MyFirstLevelRepository.class);
        System.out.println("MyFirstLevelRepository这个Bean = "+myFirstLevelRepository);
        context.close();//关闭上下文。
    }
}
