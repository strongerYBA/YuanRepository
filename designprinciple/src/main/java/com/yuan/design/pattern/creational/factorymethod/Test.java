package com.yuan.design.pattern.creational.factorymethod;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/15 13:04
 * 应用层。客户端。
 */
public class Test {
    public static void main(String[] args){
        VideoFactory videoFactory = new FEVideoFactory();
        VideoFactory videoFactory1 = new JavaVideoFactory();
        VideoFactory videoFactory2 = new PythonVideoFactory();
        Video video = videoFactory.getVideo();
        video.produce();
    }
}
