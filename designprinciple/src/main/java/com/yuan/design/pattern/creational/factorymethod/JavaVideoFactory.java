package com.yuan.design.pattern.creational.factorymethod;

/**
 * @ClassName JavaVideoFactory
 * @Author Administrator
 * @Date 2020/1/15 20:34
 */
public class JavaVideoFactory extends VideoFactory {
    public Video getVideo() {
        return new JavaVideo();
    }
}
