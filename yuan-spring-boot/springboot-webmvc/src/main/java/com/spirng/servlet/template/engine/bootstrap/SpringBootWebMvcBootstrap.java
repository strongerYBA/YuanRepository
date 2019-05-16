package com.spirng.servlet.template.engine.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot MVC引导类。
 * @ClassName SpringBootMvcBootstrap
 * @Author Administrator
 * @Date 2019/4/24 22:00
 */
@SpringBootApplication(scanBasePackages = "com.spirng.servlet.*")
public class SpringBootWebMvcBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebMvcBootstrap.class);
    }
}
