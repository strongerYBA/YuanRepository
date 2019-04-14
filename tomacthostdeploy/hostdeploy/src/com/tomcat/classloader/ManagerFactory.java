package com.tomcat.classloader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 工厂模式，加载Manager的工厂。
 * @ClassName ManagerFactory
 * @Author Administrator
 * @Date 2019/4/14 10:07
 */
public class ManagerFactory {
    //记录热加载类的加载信息。
    private  static  final Map<String,LoadInfo> loadTimeMap = new HashMap<String, LoadInfo>();
    //要加载类的classpath。
    public static  final String  CLASS_PATH = "D:/spring_boot/tomacthostdeploy/hostdeploy/";
    //实现热加载的类的全名称（包名+类名）
    public static final String MY_MANAGER = "com.tomcat.classloader.MyManager";
    public static BaseManager getManager(String className)
    {
        File  loadFile = new File(CLASS_PATH+className.replaceAll("\\.","/")+".class");
        long lastModified  = loadFile.lastModified();
        //loadTimeMap不包含className为key的loadInfo信息。证明这个类没有被加载，那么这个类需要被加载到JVM中。
        if (loadTimeMap.get(className)==null)
        {
            load(className,lastModified);
        }
        //加载类的时间戳变了。需要重新加载类到JVM。
        else if (loadTimeMap.get(className).getLoadTime()!=lastModified)
        {
            load(className,lastModified);
        }
        return loadTimeMap.get(className).getBaseManager();
    }
    private static  void  load(String className,long lastModified)
    {
        MyClassLoader classLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;
        try
        {
            loadClass = classLoader.loadClass(className);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        BaseManager baseManager = newInstance(loadClass);
        LoadInfo loadInfo = new LoadInfo(classLoader,lastModified);
        loadInfo.setBaseManager(baseManager);
        loadTimeMap.put(className,loadInfo);
    }

    /**
     * 以反射的方式创建BaseManager子类对象。
     * @param loadClass
     * @return
     */
    private static BaseManager newInstance(Class<?> loadClass)
    {
        try
        {
            return (BaseManager)loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
