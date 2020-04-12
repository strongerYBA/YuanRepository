package com.yuan.java.reflect;

/**
 * @ClassName ClassDemo1
 * @Author Administrator
 * @Date 2019/11/28 14:56
 */
public class ClassDemo1 {
    public static void main(String[] args) {
        //Yuan的实例对象如何表示。
        Yuan yuan = new Yuan();//yuan 就表示出来了

        //Yuan这个类也是一个实例对象,Class类的实例对象，如何表示呢？
        //任何一个类都是Class的实例对象，这个实例对象有三种表示方式。

        //第一种表示方式。实际告诉我们任何一个类都有一个隐含的静态成员变量class。
        Class c1 = Yuan.class;

        //第二种表达方式,已知该类的实例对象通过getClass方法。
        Class c2 = yuan.getClass();

        /*官网c1 ,c2表示了Yuan类的类类型（class type），
        即Yuan这个类本身就是一个对象，是谁的对象呢？是Class类的实例对象
        万事万物皆对象，
        类也是对象，是Class类的实例对象。
        这个对象我们称为该类的类类型。
        */
        //不管c1,c2都代表了Foo类的类类型，一个类只可能是一个Class类的实例对象。
        System.out.println(c1==c2);

        //第三种表达方式
        Class c3 = null;
        try {
            c3 = Class.forName("com.yuan.java.reflect.Yuan");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c1==c3);

        //我们可以通过类的类类型，创建该类的对象实例---》c1 or c2 or c3 创建Yuan 的实例对象yuan1。
        try {
            //前提要求，是Yuan有无参数的构造方法。
            Yuan yuan1 = (Yuan)Yuan.class.newInstance();
            yuan1.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
class Yuan{
    void print() {
        System.out.println("Yuan的实例对象测试。");
    }
}