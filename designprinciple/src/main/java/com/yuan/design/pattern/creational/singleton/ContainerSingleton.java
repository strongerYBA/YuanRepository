package com.yuan.design.pattern.creational.singleton;

import jodd.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ContainerSingleton
 * @Author Administrator
 * @Date 2020/1/18 21:36
 */
public class ContainerSingleton {
    private ContainerSingleton(){
    }
    //容器单例，就是通过map实现一个单例对象的一个容器。一个map中放入多个不同的单例对象。
    private static Map<String,Object> singleMap = new HashMap<String, Object>();
    public static void putInstance(String key,Object instance){
        if (StringUtil.isNotBlank(key) && instance!=null){
            if (!singleMap.containsKey(key)){
                singleMap.put(key,instance);
            }
        }
    }
    public static Object getInstance(String key){
        return singleMap.get(key);
    }
}
