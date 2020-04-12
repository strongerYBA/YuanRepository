package com.yuan.design.principle.liskovsubstitution.methodinput;

import java.util.HashMap;

/**
 * @ClassName Base
 * @Author Administrator
 * @Date 2020/1/14 19:49
 */
public class Base {
    public void method(HashMap map){
        System.out.println("父类被执行！");
    }
}
