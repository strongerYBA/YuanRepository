package com.yuan.design.pattern.structural.adapter;

/**
 * @ClassName AC220
 * @Author Administrator
 * @Date 2020/1/20 13:45
 * AC交流电。被适配者。
 */
public class AC220 {
    public int outputAC220(){
        int output  = 220;
        System.out.println("输出交流电 : "+output + " V");
        return output;
    }
}
