package com.yuan.design.principle.openclose;

/**
 * @ClassName test
 * @Author Administrator
 * @Date 2019/11/21 22:18
 */
public class test {
    public static void main(String[] args) {
        ICourse javaCourse = new JavaDiscountCourse(99,"java从0到企业级开发",348d);
        JavaDiscountCourse course  = (JavaDiscountCourse)javaCourse;
        System.out.println("课程id："+javaCourse.getId()+" 课程名称："+javaCourse.getName()
                +" 课程原价："+course.getPrice()+" 课程折扣价格："+course.getDiscountaPrice()+"元");
    }
}
