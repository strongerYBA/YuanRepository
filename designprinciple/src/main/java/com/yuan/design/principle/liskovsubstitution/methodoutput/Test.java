package com.yuan.design.principle.liskovsubstitution.methodoutput;

import java.util.HashMap;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/14 20:03
 */
public class Test {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.method());
    }
}
