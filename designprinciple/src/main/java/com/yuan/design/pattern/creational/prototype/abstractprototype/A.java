package com.yuan.design.pattern.creational.prototype.abstractprototype;

/**
 * @ClassName A
 * @Author Administrator
 * @Date 2020/1/19 11:44
 */
public abstract class A implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
