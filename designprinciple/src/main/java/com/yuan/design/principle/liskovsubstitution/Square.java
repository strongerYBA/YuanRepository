package com.yuan.design.principle.liskovsubstitution;

/**
 * @ClassName Square
 * @Author Administrator
 * @Date 2020/1/14 19:03
 */
public class Square implements Quadrangle{
    private long sideLength;

    public long getSideLength() {
        return sideLength;
    }

    public void setSideLength(long sideLength) {
        this.sideLength = sideLength;
    }

    public long getWidth() {
        return sideLength;
    }

    public long getLength() {
        return sideLength;
    }
}
