package yuanspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link org.springframework.boot.SpringApplication} 引导类。
 * @ClassName SpringApplicationBootstrap
 * @Author Administrator
 * @Date 2019/4/21 10:17
 */
//@SpringBootApplication//配置源。
public class SpringApplicationBootstrap
{
    public static void main(String[] args)
    {
        Set<String> source = new HashSet<>();
        source.add(SpringSource.class.getName());//通过堆栈的方式获取main方法。
        //配置class名称。
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(source);//source可以使用多种源来替代。包括xml。
//        springApplication.setWebApplicationType(WebApplicationType.NONE);//非web项目。
        ConfigurableApplicationContext run = springApplication.run(args);
        SpringSource bean = run.getBean(SpringSource.class);
        System.out.println("Bean  = "+bean);
    }
    @SpringBootApplication
    public static class  SpringSource
    {

    }
}
