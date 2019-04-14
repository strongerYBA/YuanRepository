package com.hot.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @ClassName HotDeployApplication
 * @Author Administrator
 * @Date 2019/4/14 19:02
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HotDeployApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HotDeployApplication.class);
    }

    //当打包成war包时，需要继承SpringBootServletInitializer类，并重新configure方法。
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HotDeployApplication.class   );
    }
}
