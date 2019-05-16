package com.spirng.servlet.template.engine;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Thymeleaf 模板引擎引导类。
 * @ClassName ThymeleafTemplateEngineBootstrap
 * @Author Administrator
 * @Date 2019/4/25 22:00
 */
public class ThymeleafTemplateEngineBootstrap  {
    public static void main(String[] args) throws  Exception{
        //构建引擎。
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        //创建渲染上下文。
        Context context = new Context();
        context.setVariable("message","hello Thymeleaf ...");
        //读取内容从。classpaht:templates/thymeleaf/hello-world.html
//        ResourceLoader
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        //通过classpath获取资源。
        Resource resource = resourceLoader.getResource("classpath:templates/thymeleaf/hello-world.html");
        File file = resource.getFile();
        //文件流。
        FileInputStream inputStream =  new FileInputStream(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //copy。
        IOUtils.copy(inputStream,byteArrayOutputStream);
        inputStream.close();
        //模板的内容。
        String content = byteArrayOutputStream.toString("utf-8");
        //渲染《处理》结果。
        String result =   springTemplateEngine.process(content,context);
        //输出《处理》渲染结果。
        System.out.println(result);
    }
}
