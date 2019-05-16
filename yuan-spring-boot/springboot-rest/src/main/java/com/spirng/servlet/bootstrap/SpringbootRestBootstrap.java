package com.spirng.servlet.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Springboot rest引导类。
 * @ClassName SpringbootRestBootstrap
 * @Author Administrator
 * @Date 2019/5/3 9:33
 */
@SpringBootApplication(scanBasePackages =
        {"com.spirng.servlet.controller", "com.spirng.servlet.config"}
        )
public class SpringbootRestBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestBootstrap.class);
    }
}
