package com.yuan.design.pattern.creational.builder;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/16 16:26
 */
public class Test {
    public static void main(String[] args) {
        CourseBuilder builder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(builder);

        Course course = coach.makeCourse("java","javaPPT",
                "手记","视频","问答");
        System.out.println(course);
    }
}
