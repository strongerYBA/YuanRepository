package com.yuan.design.pattern.creational.singleton;

/**
 * @ClassName T
 * @Author Administrator
 * @Date 2020/1/16 18:50
 */
public class T implements Runnable {
    public void run() {
//        LazySingleton instance = LazySingleton.getInstance();
//        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
//        StaticInnerClassSingleton instance  = StaticInnerClassSingleton.getInstance();
//        ContainerSingleton.putInstance("object",new Object());
//        Object instance = ContainerSingleton.getInstance("object");
        ThreadLocalInstance instance = ThreadLocalInstance.getInstance();
        System.out.println(Thread.currentThread().getName()+"  "+instance);
    }
}
