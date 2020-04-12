package com.yuan.design.principle.openclose;

/**
 * @ClassName JavaDiscountCourse
 * @Author Administrator
 * @Date 2019/11/21 22:28
 */
public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }
    public Double getDiscountaPrice()
    {
        return super.getPrice()*0.8;
    }
//    @Override
//    public Double getPrice() {
//        return super.getPrice()*0.8;
//    }
}
