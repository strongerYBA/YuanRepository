package com.yuan.design.principle.dependenceinversion;

/**
 * @ClassName FECourse
 * @Author Administrator
 * @Date 2019/11/24 22:04
 */
public class FECourse implements ICourse{
    public void studyCourse() {
        System.out.println("yuan 在学习前端课程");
    }
}
