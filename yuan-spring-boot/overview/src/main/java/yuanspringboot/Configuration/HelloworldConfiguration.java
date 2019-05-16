package yuanspringboot.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Hello World 配置。
 * @ClassName HelloworldConfiguration
 * @Author Administrator
 * @Date 2019/4/18 20:25
 */
@Configuration//注解驱动的方式。
public class HelloworldConfiguration {
    @Bean
    public String helloworld()//方法名，即Bean的名称。
    {
        return  "Hello.World...";
    }
}
