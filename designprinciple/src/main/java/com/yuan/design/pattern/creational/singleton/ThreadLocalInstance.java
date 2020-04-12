package com.yuan.design.pattern.creational.singleton;

/**
 * @ClassName ThreadLocalInstance
 * @Author Administrator
 * @Date 2020/1/18 22:19
 */
public class ThreadLocalInstance {
    private static final ThreadLocal<ThreadLocalInstance> threadLocalInstance
            = new ThreadLocal<ThreadLocalInstance>(){

        @Override
        protected ThreadLocalInstance initialValue() {
            //初始化。
            return new ThreadLocalInstance();
        }
    };
    private ThreadLocalInstance(){
    }
    public static ThreadLocalInstance getInstance(){
        return threadLocalInstance.get();
    }
}
