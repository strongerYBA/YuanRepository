package com.yuan.design.principle.liskovsubstitution.methodinput;

import java.util.HashMap;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/14 19:51
 */
public class Test {
    public static void main(String[] args) {
        Base child = new Child();
        HashMap hashMap = new HashMap();
        child.method(hashMap);
    }
}
