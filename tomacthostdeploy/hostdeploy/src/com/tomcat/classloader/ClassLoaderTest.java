package com.tomcat.classloader;

/**
 * 测试java类的热加载。
 * @ClassName ClassLoaderTest
 * @Author Administrator
 * @Date 2019/4/14 10:48
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        new Thread(new MsgHandler()).start();
    }
}
