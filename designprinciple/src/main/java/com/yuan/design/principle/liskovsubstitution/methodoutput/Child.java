package com.yuan.design.principle.liskovsubstitution.methodoutput;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Child
 * @Author Administrator
 * @Date 2020/1/14 20:02
 */
public class Child extends Base {

    @Override
    public HashMap method() {
        HashMap hashMap = new HashMap();
        System.out.println("子类method被执行");
        hashMap.put("Message","子类method被执行");
        return hashMap;
    }
}
