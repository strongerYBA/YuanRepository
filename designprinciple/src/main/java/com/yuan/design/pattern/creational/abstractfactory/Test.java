package com.yuan.design.pattern.creational.abstractfactory;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/16 12:37
 */
public class Test {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getArticle();
        video.produce();
        article.produce();
    }
}
