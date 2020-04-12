package com.yuan.design.pattern.creational.builder.v2;


import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/16 16:55
 */
public class Test {
    public static void main(String[] args) {
        Course course = new Course.CourseBuilder().builderCourseName("java").buildCoursePPT("javaPPT")
                .buildCourseVideo("java 视频").buildCourseQA("问答").build();
        System.out.println(course);

        Set<String> set = ImmutableSet.<String>builder().add("a").add("b").build();
        System.out.println(set);
    }
}
