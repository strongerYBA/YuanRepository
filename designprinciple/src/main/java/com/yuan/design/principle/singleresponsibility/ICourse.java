package com.yuan.design.principle.singleresponsibility;

/**
 * @ClassName ICourse
 * @Author Administrator
 * @Date 2019/11/27 19:20
 */
public interface ICourse {
    //不止一个职责。
    //职责1、获取课程信息。
    String getCourseName();
    byte[] getCourseVideo();

}
