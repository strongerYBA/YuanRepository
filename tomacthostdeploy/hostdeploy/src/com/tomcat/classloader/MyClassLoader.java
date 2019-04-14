package com.tomcat.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义java类加载器，来实现java类的热加载。
 * @ClassName MyClassLoader
 * @Author Administrator
 * @Date 2019/4/14 9:37
 */
public class MyClassLoader extends ClassLoader {
    //要加载的java类的classpath路径。
    private String classPath;
    public MyClassLoader(String classPath)
    {
        super(ClassLoader.getSystemClassLoader());
        this.classPath = classPath;
    }
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);

        return this.defineClass(name,data,0,data.length);
    }

    /**
     * 加载class中的内容。
     * @param name
     * @return
     */
    private byte[] loadClassData(String name)
    {
        try
        {
            //读取。
            name = name.replace(".","//");
            FileInputStream is = new FileInputStream(new File(classPath+name+".class"));
            //写出。
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int b = 0;
            while ((b=is.read())!= -1)
            {
                    out.write(b);
            }
            is.close();
            return out.toByteArray();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  null;
    }
 }
