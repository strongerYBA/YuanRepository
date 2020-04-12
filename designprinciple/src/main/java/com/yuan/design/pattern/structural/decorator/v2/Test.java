package com.yuan.design.pattern.structural.decorator.v2;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/19 20:40
 */
public class Test {
    public static void main(String[] args) {
        ABattercake aBattercake;
        //普通煎饼。
        aBattercake = new Battercake();
        //想要加2个鸡蛋的煎饼。
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        //还想要一个香肠。
        aBattercake = new SausageDecorator(aBattercake);
        System.out.println(aBattercake.getDesc()+" 销售价格："+aBattercake.cost());
    }
}
