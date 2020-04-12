package com.yuan.design.pattern.structural.decorator.v2;

/**
 * @ClassName Battercake
 * @Author Administrator
 * @Date 2020/1/19 20:17
 */
public class Battercake extends ABattercake {
    @Override
    protected String getDesc(){
        return "煎饼";
    }
    @Override
    protected int cost(){
        return 8;
    }
}
