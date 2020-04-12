package com.yuan.design.pattern.structural.flyweight;

/**
 * @ClassName Manager
 * @Author Administrator
 * @Date 2020/1/21 14:14
 */
public class Manager implements Employee {

    private String title = "部门经理";

    private String department;

    private String reportContent;
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
    public Manager(String department) {
        this.department = department;
    }
    public void report() {
        System.out.println(reportContent);
    }
}
