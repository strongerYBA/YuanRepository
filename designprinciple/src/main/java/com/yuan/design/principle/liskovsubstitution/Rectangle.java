package com.yuan.design.principle.liskovsubstitution;

/**
 * @ClassName Rectangle
 * @Author Administrator
 * @Date 2020/1/14 19:02
 */
public class Rectangle implements Quadrangle{
    private long length;
    private long width;
    public long getWidth() {
        return width;
    }
    public long getLength() {
        return length;
    }
    public void setLength(long length) {
        this.length = length;
    }

    public void setWidth(long width) {
        this.width = width;
    }
}
