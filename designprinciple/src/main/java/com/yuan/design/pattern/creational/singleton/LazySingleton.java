package com.yuan.design.pattern.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName LazySingleton
 * @Author Administrator
 * @Date 2020/1/16 18:43
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;
    private LazySingleton(){
        if (lazySingleton != null) {
            throw new RuntimeException("单例模式禁止反射调用！");
        }
    }
    public synchronized static LazySingleton getInstance(){
        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class objectClass = LazySingleton.class;
        Constructor constructor = objectClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        LazySingleton o2 = (LazySingleton) constructor.newInstance();
        LazySingleton o1 = LazySingleton.getInstance();
//        Field flag = o1.getClass().getDeclaredField("flag");
//        flag.setAccessible(true);
//        flag.set(o1,true);
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o1 == o2);
    }
}
