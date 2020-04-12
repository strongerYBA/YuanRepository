package com.yuan.design.pattern.creational.singleton;

/**
 * @ClassName LazyDoubleCheckSingleton
 * @Author Administrator
 * @Date 2020/1/17 15:44
 */
public class LazyDoubleCheckSingleton {
    //volatile不允许重排序。
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;
    private LazyDoubleCheckSingleton(){
    }
    public static LazyDoubleCheckSingleton getInstance(){
        if (lazyDoubleCheckSingleton == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if (lazyDoubleCheckSingleton == null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                    //1.分配内存给这个对象。
                    //2.初始化这个对象。
                    //3.设置lazyDoubleCheckSingleton指向刚才分配的内存地址。
                    //其中第2,3,步可能会被重排序，即2，3的步骤颠倒了。
                    //java语言规范intra-Thread semantics允许重排序不会改变单线程内的程序执行结果。
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
