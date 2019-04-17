package com.startclass;

import com.test.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName StartClass
 * @Description TODO
 * @Author dell
 * @Date 2019/4/15 14:06
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ServletComponentScan(value = "com.test.*")
public class FirstStartClass {
    public static void main(String[] args) {
        SpringApplication.run(FirstStartClass.class);
    }
}
