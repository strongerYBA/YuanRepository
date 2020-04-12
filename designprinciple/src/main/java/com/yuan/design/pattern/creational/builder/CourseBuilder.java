package com.yuan.design.pattern.creational.builder;

/**
 * @ClassName CourseBuilder
 * @Author Administrator
 * @Date 2020/1/16 16:04
 */
public abstract class CourseBuilder {
    public abstract void buildCourseName(String courseName);
    public abstract void buildCoursePPT(String coursePPT);
    public abstract void buildCourseVideo(String courseVideo);
    public abstract void buildCourseArticle(String courseArticle);
    public abstract void buildCourseQA(String courseQA);
    public abstract Course makeCourse();
}
