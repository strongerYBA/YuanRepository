package yuanspringboot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring 应用事件引导类。
 * @ClassName SpringApplicationEventBootstrap
 * @Author Administrator
 * @Date 2019/4/21 17:12
 */
public class SpringApplicationEventBootstrap {
    public static void main(String[] args) {
        //创建上下文。
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册应用事件监听器。
        context.addApplicationListener( evnet ->
        {
            System.out.println("监听到事件 ："+evnet);
        });
        //启动.
        context.refresh();
        //发送事件。
        context.publishEvent("hello world ...");
        context.publishEvent("hello world ...ni  hao a ...");
        context.publishEvent(new ApplicationEvent("hi ni hao ....") {
        });
       //关闭。
        context.close();
    }
}
