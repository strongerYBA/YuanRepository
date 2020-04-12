package com.yuan.java.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *java反射测试
 * @ClassName MethodDemo4
 * @Author Administrator
 * @Date 2019/12/4 22:10
 */
public class MethodDemo4 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("hello");
        Class c1 = arrayList.getClass();
        Class c2 = stringArrayList.getClass();
        System.out.println(c1 == c2);
        /**
         * 反射的操作都是编译之后的操作。
         *
         *
         * c1 == c2 结果为true。说明编译之后集合的泛型是去泛型化的。
         * java中集合泛型是防止错误输入的，只在编译阶段有效。绕过编译就无效了。
         * 验证：我们可以通过方法的反射来操作，绕过编译。
         */
        try {
            Method method = c2.getMethod("add", Object.class);
            method.invoke(stringArrayList, 10);
            //绕过编译，就绕过了泛型。
            System.out.println(stringArrayList.size());
            System.out.println(stringArrayList);
            //此时不能用foreach进行遍历了。
//            for (String s : stringArrayList) {
//
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
