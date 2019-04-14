package com.tomcat.classloader;

/**
 * BaseManager的子类，此类需要实现java类的热加载功能。
 * @ClassName MyManager
 * @Author Administrator
 * @Date 2019/4/14 9:52
 */
public class MyManager implements BaseManager {

    @Override
    public void logic() {
        System.out.println("今天学习java类的热加载案例2。。。");
        System.out.println("今天很高兴111111111。。。");
        System.out.println("今天很嗨皮。。。");
        System.out.println("今天吃火锅。。。");
    }
}
