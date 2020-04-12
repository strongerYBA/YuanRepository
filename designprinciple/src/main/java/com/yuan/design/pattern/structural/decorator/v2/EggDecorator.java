package com.yuan.design.pattern.structural.decorator.v2;

/**
 * @ClassName EggDecorator
 * @Author Administrator
 * @Date 2020/1/19 20:37
 */
public class EggDecorator extends AbastractDecorator {
    public void doSomething() {
    }

    public EggDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc()+"加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost()+1;
    }
}
