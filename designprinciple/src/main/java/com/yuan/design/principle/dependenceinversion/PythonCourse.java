package com.yuan.design.principle.dependenceinversion;

/**
 * @ClassName PythonCourser
 * @Author Administrator
 * @Date 2019/11/24 22:28
 */
public class PythonCourse implements ICourse {
    public void studyCourse() {
        System.out.println("yuan 在学习Python课程");
    }
}
