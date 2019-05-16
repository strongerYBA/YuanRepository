package com.spirng.servlet.domain;

/**
 * 用户模型对象。
 * @ClassName USer
 * @Author Administrator
 * @Date 2019/5/3 10:23
 */
public class User {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
