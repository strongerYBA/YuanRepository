package com.yuan.design.principle.openclose;

/**
 * @ClassName JavaCourse java课程， 可能有多个课程，这里只写一个java课程。
 * @Author Administrator
 * @Date 2019/11/21 22:16
 */
public class JavaCourse implements ICourse{
    private Integer Id;
    private String name;
    private Double price;
    public JavaCourse(Integer id, String name, Double price) {
        this.Id = id;
        this.name = name;
        this.price = price;
    }
    public Integer getId() {
        return this.Id;
    }
    public String getName() {
        return this.name;
    }
    public Double getPrice() {
        return this.price;
    }
}
