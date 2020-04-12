package com.yuan.design.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TeamLeader
 * @Author Administrator
 * @Date 2019/11/28 10:39
 */
public class TeamLeader {
    public void checkNumberOfCourses(){
        List<Course> courses = new ArrayList<Course>();
        for (int i = 0; i <20 ; i++) {
            courses.add(new Course());
        }
        System.out.println("在线课程的数量是： "+courses.size());
    }
}
