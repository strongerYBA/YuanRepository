package com.tomcat.classloader;

/**
 * 封装加载类的信息。
 * @ClassName LoadInfo
 * @Author Administrator
 * @Date 2019/4/14 9:59
 */
public class LoadInfo {
    //自定义的类加载器。
    private MyClassLoader myClassLoader;
    //记录要加载类的时间戳。--->加载到java虚拟机的时间。
    private long loadTime;
    private  BaseManager baseManager;

    public LoadInfo(MyClassLoader myClassLoader, long loadTime) {
        super();
        this.myClassLoader = myClassLoader;
        this.loadTime = loadTime;
    }

    public MyClassLoader getMyClassLoader() {
        return myClassLoader;
    }

    public void setMyClassLoader(MyClassLoader myClassLoader) {
        this.myClassLoader = myClassLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getBaseManager() {
        return baseManager;
    }

    public void setBaseManager(BaseManager baseManager) {
        this.baseManager = baseManager;
    }
}
