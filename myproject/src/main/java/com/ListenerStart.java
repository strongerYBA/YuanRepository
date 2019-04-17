//package com;
//
//import ch.qos.logback.classic.joran.action.ConfigurationAction;
//import com.test.servlet.FirstListener;
//import com.test.servlet.MyEvent;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.context.ConfigurableApplicationContext;
//
///**
// * @ClassName ListenerStart
// * @Description TODO
// * @Author dell
// * @Date 2019/4/17 16:14
// */
//@SpringBootApplication(
//        exclude = {DataSourceAutoConfiguration.class}
//)
//public class ListenerStart {
//    public static void main(String[] args) {
//        //创建一个可执行的spring应用程序。
//        SpringApplication springApplication = new SpringApplication();
//        //配置事件监听。
//        springApplication.addListeners(new FirstListener());
//        //配置应用程序上下文。
//        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
//        //发布事件。
//        configurableApplicationContext.publishEvent(new MyEvent(new Object()));
//        //关闭监听器。
//        configurableApplicationContext.close();
//    }
//}
