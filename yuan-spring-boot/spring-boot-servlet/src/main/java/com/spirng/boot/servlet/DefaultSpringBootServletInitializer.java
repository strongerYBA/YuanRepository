package com.spirng.boot.servlet;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**{@link SpringBootServletInitializer}默认实现。
 * @ClassName DefaultSpringBootServletInitializer
 * @Author Administrator
 * @Date 2019/5/8 22:25
 */
public class DefaultSpringBootServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(SpringBootServletBootStrap.class);//扩展该类。

        return super.configure(builder);
    }
}
