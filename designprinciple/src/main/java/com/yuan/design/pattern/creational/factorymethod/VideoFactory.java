package com.yuan.design.pattern.creational.factorymethod;

/**
 * @ClassName VideoFactory
 * @Author Administrator
 * @Date 2020/1/15 13:06
 */
public abstract class VideoFactory {
    //为什么不用接口，因为在实际使用的时候，有些实现是已知的，不用子类实现。故用抽象类比较好。
    public abstract Video getVideo();
//    public Video getVideo(Class c){
//        Video video = null;
//        try {
//            video = (Video) Class.forName(c.getName()).newInstance();
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return video;
//    }
//    public Video getVideo(String type){
//        if ("java".equalsIgnoreCase(type)){
//            return new JavaVideo();
//        }else if ("python".equalsIgnoreCase(type)){
//            return new PythonVideo();
//        }
//        return null;
//    }
}
