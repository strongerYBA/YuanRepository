package com.yuan.design.pattern.structural.flyweight;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/21 14:21
 */
public class Test {
    private static final String departments[] = {"RA","RD","PM","LD"};

    public static void main(String[] args) {
//        for (int i = 0; i <10 ; i++) {
//            //获取部门名称
//            String dapartment = departments[(int) (Math.random()*departments.length)];
//            Manager manager = (Manager) EmployeeFactory.getManager(dapartment);
//            manager.report();
//        }
        Integer a = Integer.valueOf(100);
        Integer b = 100;
        Integer c = Integer.valueOf(1000);
        Integer d = 1000;
        System.out.println("a == b : "+(a==b));
        System.out.println("c == d : "+(c==d));
    }
}
