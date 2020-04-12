package com.yuan.design.pattern.structural.decorator.v1;

/**
 * @ClassName BattercakeWithEgg
 * @Author Administrator
 * @Date 2020/1/19 20:18
 */
public class BattercakeWithEgg extends  Battercake {
    @Override
    public String getDesc() {
        return super.getDesc()+"加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost()+1;
    }
}
