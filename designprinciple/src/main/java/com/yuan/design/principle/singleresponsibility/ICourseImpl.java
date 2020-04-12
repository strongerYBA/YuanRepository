package com.yuan.design.principle.singleresponsibility;

/**
 * @ClassName ICourseImpl
 * @Author Administrator
 * @Date 2019/11/27 19:26
 */
public class ICourseImpl implements ICourseContent,ICourseManager
{
    public String getCourseName() {
        return null;
    }

    public byte[] getCourseVideo() {
        return new byte[0];
    }

    public void studyCourse() {

    }

    public void refundCourse() {

    }
}
