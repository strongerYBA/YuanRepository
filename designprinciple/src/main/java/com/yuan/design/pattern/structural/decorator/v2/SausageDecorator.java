package com.yuan.design.pattern.structural.decorator.v2;

/**
 * @ClassName SausageDecorator
 * @Author Administrator
 * @Date 2020/1/19 20:37
 */
public class SausageDecorator extends AbastractDecorator {
    public void doSomething() {

    }

    //为何实现这个构造器，因为父类已经没有无参数构造器了。
    public SausageDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc()+"加一个香肠";
    }

    @Override
    protected int cost() {
        return super.cost()+2;
    }
}
