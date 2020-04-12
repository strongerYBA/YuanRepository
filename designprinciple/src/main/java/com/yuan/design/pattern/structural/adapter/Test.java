package com.yuan.design.pattern.structural.adapter;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/20 13:51
 */
public class Test {
    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter();
        dc5.outputDC5V();
    }
}
