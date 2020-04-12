package com.yuan.design.pattern.structural.decorator.v2;

/**
 * @ClassName AbastractDecorator
 * @Author Administrator
 * @Date 2020/1/19 20:33
 */
public abstract class AbastractDecorator extends ABattercake{
    private ABattercake aBattercake;

    public abstract void doSomething();
    public AbastractDecorator(ABattercake aBattercake) {
        this.aBattercake = aBattercake;
    }

    protected String getDesc() {
        return this.aBattercake.getDesc();
    }

    protected int cost() {
        return this.aBattercake.cost();
    }
}
