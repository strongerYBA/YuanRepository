package com.yuan.design.pattern.creational.factorymethod;

/**
 * @ClassName PythonVideoFactory
 * @Author Administrator
 * @Date 2020/1/15 20:34
 */
public class PythonVideoFactory extends VideoFactory {
    public Video getVideo() {
        return new PythonVideo();
    }
}
