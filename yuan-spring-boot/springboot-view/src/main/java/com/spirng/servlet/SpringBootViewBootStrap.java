package com.spirng.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 引导类。
 * @ClassName SpringBootViewBootStrap
 * @Author Administrator
 * @Date 2019/4/25 22:42
 */
@SpringBootApplication(scanBasePackages = "com.spirng.servlet.*")
public class SpringBootViewBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootViewBootStrap.class);
    }

}
