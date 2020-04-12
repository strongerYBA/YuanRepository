package com.yuan.design.principle.dependenceinversion;

/**
 * @ClassName yuan 一个人可以学多个课程。
 * @Author Administrator
 * @Date 2019/11/24 21:58
 */
public class Yuan {
    private  ICourse course;
    public void setCourse(ICourse course) {
        this.course = course;
    }
    public void studyCourse()
    {
        course.studyCourse();
    }
}
