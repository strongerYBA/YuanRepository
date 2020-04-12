package com.yuan.design.principle.singleresponsibility;

/**
 * @ClassName test
 * @Author
 * @Date 2019/11/27 18:59
 */
public class Test {
    public static void main(String[] args) {

        //1、类级别的单一职责原则。
//        Bird bird = new Bird();
//        bird.mainMoveMode("大雁");
//        bird.mainMoveMode("鸵鸟");//鸵鸟用翅膀飞是不对的。鸵鸟飞不起来。
        FlyBird flyBird = new FlyBird();
        flyBird.mainMoveMode("大雁");
        WalkBird walkBird = new WalkBird();
        walkBird.mainMoveMode("鸵鸟");
        //2、接口级别的但一职责原则。
    }
}
