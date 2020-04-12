package com.yuan.design.pattern.creational.factorymethod;

/**
 * @ClassName FEVideoFactory
 * @Author Administrator
 * @Date 2020/1/15 20:56
 */
public class FEVideoFactory extends VideoFactory {
    public Video getVideo() {
        return new FEVideo();
    }
}
