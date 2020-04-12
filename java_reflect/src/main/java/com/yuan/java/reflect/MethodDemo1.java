package com.yuan.java.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName MethodDemo1
 * @Author Administrator
 * @Date 2019/12/3 22:19
 */
public class MethodDemo1 {
    public static void main(String[] args) {
        //获取print(int , int )方法
        //1、获取的一个方法就是获取类的信息，获取类的信息，首先要获取类的类类型。
        A a1 = new A();
        Class c = a1.getClass();
        //2、获取方法、名称和参数列表来决定。
        //c.getMethod()获取的是public的方法。
        //c.getDeclaredMethod();获取自己声明的方法。
        try {
//            Method method = c.getMethod("print", new Class[]{int.class, int.class});
            Method  method= c.getMethod("print", int.class, int.class);
            //方法的反射操m作。
//正常调用            a1.print(10,20);
            /**
             * 方法的反射操作是用method对象来进行方法的掉用。和a1.print()调用的效果相同。
             * 可以理解为print变成方法对象了，那么就是a1这个对象操作print对象，
             * 同样的也可用print这个方法所代表的对象m来操作a1这个对象，即为反射。
             * 如果没有返回值，返回null,如果有返回值，返回具体的返回值。（强转）
             */
//            Object invoke1 = method.invoke(a1, new Object[]{10, 20});
            Object invoke = method.invoke(a1, 10, 20);
            Method  mm= c.getMethod("print", String.class, String.class,String.class);
            String invoke1 = (String) mm.invoke(a1, "hello-", "world-", "yuan");
            System.out.println(invoke1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
class A{
    public void print(int a,int b){
        System.out.println(a+b);
    }
    public void print(String a, String b){
        System.out.println(a.toUpperCase()+","+b.toLowerCase());
    }
    public String print(String a, String b,String c){
        return a+b+c;
    }
}
