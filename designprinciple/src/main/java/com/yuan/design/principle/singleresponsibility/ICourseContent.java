package com.yuan.design.principle.singleresponsibility;

/**
 * 接口级别的单一职责。
 * @ClassName ICourseContent
 * @Author Administrator
 * @Date 2019/11/27 19:25
 */
public interface ICourseContent {
    //职责1、获取课程信息。
    String getCourseName();
    byte[] getCourseVideo();
}
