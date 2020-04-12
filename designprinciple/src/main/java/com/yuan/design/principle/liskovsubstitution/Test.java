package com.yuan.design.principle.liskovsubstitution;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/14 19:11
 * 长方形类和正方形类不符合里氏替换原则。
 */
public class Test {
    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() <= rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth()+1);
            System.out.println("width:"+rectangle.getWidth()+"length:"+rectangle.getLength());
        }
        System.out.println("resize方法结束 width:"+rectangle.getWidth()+" length:"+rectangle.getLength());
    }
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setLength(20);
        resize(rectangle);
//        System.out.println("+++++++++++++");
//        Square square = new Square();
//        square.setLength(10);
//        resize(square);

    }
}
