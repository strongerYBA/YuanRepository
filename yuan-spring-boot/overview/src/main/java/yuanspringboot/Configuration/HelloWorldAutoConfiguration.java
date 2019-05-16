package yuanspringboot.Configuration;

import org.springframework.context.annotation.Configuration;
import yuanspringboot.annotation.EnableHelloworld;
import yuanspringboot.condition.ConditionalOnSystemProperty;

/**
 * Hello World 自动装配。
 * @ClassName HelloWorldAutoConfiguration
 * @Author Administrator
 * @Date 2019/4/20 23:21
 */
@Configuration//模式注解。
@EnableHelloworld//Spring @Enable 模块装配。
@ConditionalOnSystemProperty(name = "user.name",value = "Administrator")//条件装配。
public class HelloWorldAutoConfiguration {
}
