package com.yuan.design.pattern.structural.adapter.classadapter;

/**
 * @ClassName Adapter
 * @Author Administrator
 * @Date 2020/1/20 13:16
 */
public class Adapter extends Adaptee implements Target {
    //通过Adapter（适配者）调用父类Adaptee（被适配者）的方法类实现了Target的方法（新的接口，目标方法）。
    public void request() {
        super.adapteeRequest();
    }
}
