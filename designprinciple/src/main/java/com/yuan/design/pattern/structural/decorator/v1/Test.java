package com.yuan.design.pattern.structural.decorator.v1;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/19 20:21
 */
public class Test {
    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getDesc()+" 销售价格："+battercake.cost());

        BattercakeWithEgg battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getDesc()+" 销售价格："+battercakeWithEgg.cost());

        BattercakeWithSausage battercakeWithEgg1 = new BattercakeWithSausage();
        System.out.println(battercakeWithEgg1.getDesc()+" 销售价格："+battercakeWithEgg1.cost());
    }
}
