package com.yuan.design.principle.demeter;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2019/11/28 10:48
 */
public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckNumber(teamLeader);
    }
}
