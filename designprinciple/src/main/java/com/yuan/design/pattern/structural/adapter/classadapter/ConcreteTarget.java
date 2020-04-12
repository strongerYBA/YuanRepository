package com.yuan.design.pattern.structural.adapter.classadapter;

/**
 * @ClassName ConcreteTarget
 * @Author Administrator
 * @Date 2020/1/20 13:16
 */
public class ConcreteTarget implements Target {
    public void request() {
        System.out.println("ConcreteTarget 目标方法 。。。");
    }
}
