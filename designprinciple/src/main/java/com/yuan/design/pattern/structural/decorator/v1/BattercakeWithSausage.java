package com.yuan.design.pattern.structural.decorator.v1;

/**
 * @ClassName BattercakeWithSausage
 * @Author Administrator
 * @Date 2020/1/19 20:19
 */
public class BattercakeWithSausage extends BattercakeWithEgg {

    @Override
    public String getDesc() {
        return super.getDesc()+"加一根香肠";
    }

    @Override
    public int cost() {
        return super.cost()+2;
    }
}
