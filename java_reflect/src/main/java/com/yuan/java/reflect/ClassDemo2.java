package com.yuan.java.reflect;

/**
 * @ClassName ClassDemo2
 * @Author Administrator
 * @Date 2019/11/29 18:47
 */
public class ClassDemo2 {
    public static void main(String[] args) {
        Class c1 = int.class;//int的类类型。
        Class c2 = String.class;//String类的类类型 或者说String类字节码。
        Class c3 = double.class;//double数据类型的字节码表示方式。
        Class c4 = Double.class;//Double这个类的类类型，字节码表示方式。
        Class c5 = void.class;
        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());//不包含包名的类的名称。
        System.out.println(c5.getName());
    }
}
