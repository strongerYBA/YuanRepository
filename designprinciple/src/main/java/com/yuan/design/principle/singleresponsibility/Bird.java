package com.yuan.design.principle.singleresponsibility;

/**
 * @ClassName Bird
 * @Author Administrator
 * @Date 2019/11/27 18:58
 */
public class Bird {
    public void mainMoveMode(String birdName) {
        if ("鸵鸟".equals(birdName)) {
            System.out.println(birdName+" 用脚走！");
        } else {
            System.out.println(birdName+" 用翅膀飞！");
        }
    }
}
