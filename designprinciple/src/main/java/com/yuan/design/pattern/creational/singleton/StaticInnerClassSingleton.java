package com.yuan.design.pattern.creational.singleton;

/**
 * @ClassName StaticInnerClassSingleton
 * @Author Administrator
 * @Date 2020/1/17 16:37
 */
public class StaticInnerClassSingleton {
    private static class InnerClass{
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }
    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.staticInnerClassSingleton;
    }
    private StaticInnerClassSingleton(){
        //反射防御。
        if (InnerClass.staticInnerClassSingleton != null){
            throw new RuntimeException("单例构造器禁止反射调用！");
        }
    }
}
