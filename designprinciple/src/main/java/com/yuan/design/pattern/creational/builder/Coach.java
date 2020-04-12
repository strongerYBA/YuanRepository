package com.yuan.design.pattern.creational.builder;

/**
 * @ClassName Coach
 * @Author Administrator
 * @Date 2020/1/16 16:11
 */
public class Coach {
    private CourseBuilder courseBuilder;

    public void setCourseBuilder(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }
    public Course makeCourse(String courseName,String coursePPT,
                             String courseArticle,String courseVideo,
                             String courseQA){
        this.courseBuilder.buildCourseName(courseName);
        this.courseBuilder.buildCourseArticle(courseArticle);
        this.courseBuilder.buildCoursePPT(coursePPT);
        this.courseBuilder.buildCourseQA(courseQA);
        this.courseBuilder.buildCourseVideo(courseVideo);
        return  this.courseBuilder.makeCourse();
    }
}
