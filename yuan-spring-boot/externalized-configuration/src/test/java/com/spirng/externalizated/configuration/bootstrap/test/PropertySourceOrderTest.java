package com.spirng.externalizated.configuration.bootstrap.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 外部化配置属性源  {@link org.springframework.core.env.PropertySource}
 * 顺序测试用例。
 * @ClassName PropertySourceOrderTest
 * @Author Administrator
 * @Date 2019/5/15 21:58
 */
@RunWith(SpringRunner.class)//spring framework 集成测试。
@TestPropertySource(
//        properties = "user.id = 9",
        locations = "classpath:/META-INF/default.properties"
)
@SpringBootTest(
//        properties = "user.id = 8",
        classes = {PropertySourceOrderTest.class}
        , webEnvironment = SpringBootTest.WebEnvironment.NONE
)//非web程序。
@Configuration
@PropertySource(name = "test-property-source",value = "classpath:/META-INF/test.properties")
public class PropertySourceOrderTest {

//    @Configuration
//    @PropertySource(name = "test-property-source",value = "classpath:/META-INF/test.properties")
//    public static class myConfig{
//
//    }
    @Value("${user.id}")
    private Long userId;
    @Autowired
    private ConfigurableEnvironment environment;
    @Autowired
    private ConfigurableApplicationContext applicationContext;
    @Test
    public  void testEnvironment()
    {
        Assert.assertSame(environment,applicationContext.getEnvironment());
    }
    @Test
    public  void  testUserId()
    {
        Assert.assertEquals(new Long(7L),userId);
    }
    @Test
    public void testPropertySources()
    {
         environment.getPropertySources().forEach(propertySource -> {
             System.out.printf("PropertySource[名称：%s]：%s\n",propertySource.getName(),propertySource);
             System.out.println();
         });
    }
}
