package com.yuan.design.pattern.structural.adapter.objectadapter;

/**
 * @ClassName Adapter
 * @Author Administrator
 * @Date 2020/1/20 13:34
 */
public class Adapter implements  Target {
    private Adaptee adaptee = new Adaptee();
    public void request() {
        //加一些代码。
        adaptee.adapteeRequest();
        //......
    }
}
