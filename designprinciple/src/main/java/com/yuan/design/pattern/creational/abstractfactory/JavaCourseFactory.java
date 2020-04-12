package com.yuan.design.pattern.creational.abstractfactory;

/**
 * @ClassName JavaCourseFactory
 * @Author Administrator
 * @Date 2020/1/16 12:16
 */
public class JavaCourseFactory implements CourseFactory {
    public Video getVideo() {
        return new JavaVideo();
    }

    public Article getArticle() {
        return new JavaArticle();
    }
}
