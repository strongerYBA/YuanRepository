package com.yuan.design.pattern.creational.prototype.abstractprototype;

/**
 * @ClassName B
 * @Author Administrator
 * @Date 2020/1/19 11:44
 */
public class B extends A {
    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B();
        b.clone();
    }
}
