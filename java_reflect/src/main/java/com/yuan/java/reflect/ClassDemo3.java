package com.yuan.java.reflect;

/**
 * @ClassName ClassDemo3
 * @Author Administrator
 * @Date 2019/11/30 11:54
 */
public class ClassDemo3 {
    public static void main(String[] args) {
         String s = "hello";
        System.out.println("。。。。。。。。。。方法信息。。。。。。。。。。。。。。。。。。");
         ClassUtil.printClassMethodMessage(s);
         System.out.println("。。。。。。。。。。成员变量信息。。。。。。。。。。。。。。。。。。");
         ClassUtil.printClassFieldMessage(s);
         ClassUtil.printConMessage(s);
        //通过Class类的类类型，获取该类的所有方法信息。
//         Integer integer = 1;
//         ClassUtil.printClassMethodMessage(integer);
    }
}
