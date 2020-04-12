package com.yuan.design.pattern.creational.singleton;

import java.io.Serializable;

/**
 * @ClassName HungarySingleton
 * @Author Administrator
 * @Date 2020/1/17 20:11
 */
public class HungrySingleton implements Serializable ,Cloneable {
    private  final static HungrySingleton hungrySingleton;
    static {
        hungrySingleton = new HungrySingleton();
    }
    //反射防御。
    private HungrySingleton(){
        if (hungrySingleton != null){
            throw new RuntimeException("单例构造器禁止反射调用！");
        }
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
    //保证不被序列化破坏。
    private Object readResolve(){
        return hungrySingleton;
    }
}
