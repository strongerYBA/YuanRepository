package com.yuan.design.principle.singleresponsibility;

/**
 * 类级别的单一职责。会走的鸟。
 * @ClassName WalkBird
 * @Author Administrator
 * @Date 2019/11/27 19:05
 */
public class WalkBird {
    public void mainMoveMode(String birdName) {
        System.out.println(birdName+" 用脚走！");
    }
}
