package com.yuan.design.pattern.creational.abstractfactory;

/**
 * @ClassName PythonCourseFactory
 * @Author Administrator
 * @Date 2020/1/16 12:21
 */
public class PythonCourseFactory implements CourseFactory {
    public Video getVideo() {
        return new PythonVideo();
    }

    public Article getArticle() {
        return new PythonArticle();
    }
}
