package com.yuan.design.principle.singleresponsibility;

/**
 * 接口级别的单一职责。
 * @ClassName ICourseManager
 * @Author Administrator
 * @Date 2019/11/27 19:24
 */
public interface ICourseManager {
    //职责2、课程管理上的一些处理,退款会影响课程内容的获取，故拆分成两个大的职责。
    void studyCourse();
    void refundCourse();
}
