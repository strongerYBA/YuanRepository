package com.yuan.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ClassDemo3
 * @Author Administrator
 * @Date 2019/11/30 11:11
 */
public class ClassUtil {
    /**
     * 打印类的信息，包括类的成员函数，成员变量
     * @param obj 该对象所属的信息。
     */
    public static void printClassMethodMessage(Object obj){
        //要获取类的信息。首先要获取类的类类型。
        Class aClass = obj.getClass();//传递的是哪个子类的对象，c就是该子类的类类型。
        //获取类的名称。
        System.out.println("类的名称是："+aClass.getName());
        /**
         * Method类，方法对象。
         * 一个成员方法就是一个Method对象
         * getMethods()方法获取的是所有的public的函数，包括父类继承而来的。
         * getDeclaredMethods();方法获取的是所有该类自己声明的方法，不问访问权限
         */
        Method[] methods = aClass.getMethods();//aClass.getDeclaredMethods();
        for (int i = 0; i <methods.length ; i++) {
            //获取方法的返回值类型---》返回值类型的类类型。
            Class returnType = methods[i].getReturnType();
            //获得返回值类型的名称。
            System.out.print(returnType.getSimpleName()+" ");
            //获取方法的名称。
            System.out.print(""+methods[i].getName()+"(");
            //获取参数类型 --> 得到的是参数列表的类型的类类型。
            Class[] parameterTypes = methods[i].getParameterTypes();
            for (Class c:parameterTypes) {
                System.out.print(c.getSimpleName()+",");
            }
            System.out.println(")");
        }
    }

    /**
     * 打印对象自身声明的成员变量信息。
     * @param o
     */
    public static void printClassFieldMessage(Object o) {
        Class aClass = o.getClass();
        /**
         * 成员变量也是对象。
         * java.lang.reflect.field
         * Field类封装了关于成员变量的操作。
         * getFields()方法获取的是所有public的成员变量的信息。
         *getDeclaredFields()获取的是该类自己声明的成员变量的信息。
         */
//            Field[] fields = aClass.getFields();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //得到成员变量的类型的类类型。
            Class fieldType = declaredField.getType();
            String typeName = fieldType.getName();
            //或的成员变量的名称。
            String fieldName = declaredField.getName();
            System.out.println(typeName+" "+fieldName);
        }
    }

    /**
     * 打印对象的构造函数的信息。
     * @param obj
     */
    public static void printConMessage(Object obj) {
        Class c = obj.getClass();
        //构造函数也是对象。java.lang.Constructor中封装了构造函数的信息。
        //c.getConstructors()获取所有public的构造函数。
        //c.getDeclaredConstructors()得到所有的构造函数。
//        Constructor[] constructors = c.getConstructors();
        Constructor[] declaredConstructors = c.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.print(constructor.getName()+"(");
            //获取构造函数的参数列表。-->得到是参数列表的类类型。
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.print(parameterType.getName()+",");

            }
            System.out.println(")");
        }
    }
}
