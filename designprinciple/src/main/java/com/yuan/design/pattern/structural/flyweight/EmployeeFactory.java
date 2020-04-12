package com.yuan.design.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EmployeeFactory
 * @Author Administrator
 * @Date 2020/1/21 14:16
 */
public class EmployeeFactory  {
    private final static Map<String ,Employee> EMPLOYEE_MAP=new HashMap<String, Employee>();
    public static Employee getManager(String department){
        Manager manager = (Manager) EMPLOYEE_MAP.get(department);
        if (manager ==null){
            //第一次要创建经理，以及报告，放入池子中，以后就直接拿来用就行了。
            manager = new Manager(department);
            System.out.print("创建部门经理： "+department);
            String reportContent = department+" 部门汇报：此次报告的内容是：。。。。。。";
            manager.setReportContent(reportContent);
            System.out.println(" 创建报告： "+reportContent);
            EMPLOYEE_MAP.put(department,manager);
        }
        return manager;
    }
}
