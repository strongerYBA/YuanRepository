package com.yuan.design.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Boss
 * @Author Administrator
 * @Date 2019/11/28 10:38
 */
public class Boss {
    public void commandCheckNumber(TeamLeader teamLeader) {
        teamLeader.checkNumberOfCourses();
    }
}
