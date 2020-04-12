package com.yuan.design.pattern.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName Tet
 * @Author Administrator
 * @Date 2020/1/16 18:48
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println("main Thread"+ThreadLocalInstance.getInstance());
        System.out.println("main Thread"+ThreadLocalInstance.getInstance());
        System.out.println("main Thread"+ThreadLocalInstance.getInstance());
        System.out.println("main Thread"+ThreadLocalInstance.getInstance());
        System.out.println("main Thread"+ThreadLocalInstance.getInstance());
        System.out.println("main Thread"+ThreadLocalInstance.getInstance());
        Thread thread = new Thread(new T());
        Thread thread1 = new Thread(new T());
        thread.start();
        thread1.start();
        System.out.println("program end ");
//        HungrySingleton instance = HungrySingleton.getInstance();
//        EnumInstance instance = EnumInstance.getInstance();
//        instance.setData(new Object());
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("EnumInstance_file"));
//        //写文件。a
//        oos.writeObject(instance);
//        File file = new File("EnumInstance_file");
//        //读文件。
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//        EnumInstance newInstance = (EnumInstance) ois.readObject();
////        HungrySingleton newInstance = (HungrySingleton) ois.readObject();
//        System.out.println("instance.getData() = "+instance.getData());
//        System.out.println("newInstance.getData() = "+newInstance.getData());
//        System.out.println(instance.getData() == newInstance.getData());
//        Class ojectClass = HungrySingleton.class;
//        Class ojectClass = StaticInnerClassSingleton.class;
//        Class objectClass = LazySingleton.class;
//        Class objectClass = EnumInstance.class;
//        Constructor constructor = objectClass.getDeclaredConstructor(String.class,int.class);
//        constructor.setAccessible(true);//改权限。
//       EnumInstance enumInstance = (EnumInstance) constructor.newInstance("yuan",111);
//        LazySingleton newInstance = (LazySingleton) constructor.newInstance();
//        LazySingleton instance = LazySingleton.getInstance();
//        EnumInstance instance = EnumInstance.getInstance();
//        EnumInstance newInstance = (EnumInstance) constructor.newInstance();
//        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
//        StaticInnerClassSingleton newInstance = (StaticInnerClassSingleton) constructor.newInstance();
//        HungrySingleton instance = HungrySingleton.getInstance();
//        HungrySingleton newInstance = (HungrySingleton) constructor.newInstance();
//        因为该权限了。所以调用构造器newInstance是新建了一个对象
//        System.out.println("instance = "+instance);
//        System.out.println("newInstance = "+newInstance);
//        System.out.println(instance == newInstance);
//
//        EnumInstance instance = EnumInstance.getInstance();
//        instance.printTest();

    }
}
