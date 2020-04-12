package com.yuan.design.principle.singleresponsibility;

/**
 * 类级别的单一职责,会飞的鸟。
 * @ClassName FlyBird
 * @Author Administrator
 * @Date 2019/11/27 19:04
 */
public class FlyBird {
    public void mainMoveMode(String birdName) {
        System.out.println(birdName+" 用翅膀飞！");
    }
}
