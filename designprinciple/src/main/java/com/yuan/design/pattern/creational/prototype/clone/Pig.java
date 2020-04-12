package com.yuan.design.pattern.creational.prototype.clone;

import java.util.Date;

/**
 * @ClassName Pig
 * @Author Administrator
 * @Date 2020/1/19 11:48
 */
public class Pig implements Cloneable {
    private String name;
    private Date birthday;

    public Pig(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Pig pig = (Pig) super.clone();
        //深克隆,对生日单独对象也要进行克隆。使用原型模式的一个坑，要注意。
        pig.birthday = (Date) pig.birthday.clone();
        return pig;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}'+super.toString();
    }
}
