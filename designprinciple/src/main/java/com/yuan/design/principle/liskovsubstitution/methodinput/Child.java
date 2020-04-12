package com.yuan.design.principle.liskovsubstitution.methodinput;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Child
 * @Author Administrator
 * @Date 2020/1/14 19:50
 */
public class Child extends Base {
//    @Override
//    public void method(HashMap map) {
//        System.out.println("子类HashMap被执行！");
//    }
    public void method(Map map) {
        System.out.println("子类Map被执行！");
    }
}
