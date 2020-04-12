package com.yuan.design.pattern.creational.simplefactory;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/15 13:04
 * 应用层。客户端。
 */
public class Test {
    public static void main(String[] args) {
//        VideoFactory videoFactory = new VideoFactory();
//        Video video = videoFactory.getVideo("java");
//        if (video == null){
//            return;
//        }
//        video.produce();
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(JavaVideo.class);
        if (video == null){
            return;
        }
        video.produce();
    }
}
