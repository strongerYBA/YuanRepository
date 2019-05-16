package yuanspringboot.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 系统属性条件引导类。
 * @ClassName SystemPropertyConditionBootstrap
 * @Author Administrator
 * @Date 2019/4/18 21:55
 */

public class SystemPropertyConditionBootstrap {
//    @ConditionalOnSystemProperty(name = "user.name",value = "袁碧安")
// 采用编程方式，利用此注解，可以确定是否能够获得此Bean实例。如果为true.就可以，不为true。就不能获取此bean。
    @Bean
    public String hellWorld()
    {
        return "hello,world ...袁碧安";
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SystemPropertyConditionBootstrap.class)
                .web(WebApplicationType.NONE)//非web类型。
                .run(args);
        context.close();//关闭上下文。
    }
}
