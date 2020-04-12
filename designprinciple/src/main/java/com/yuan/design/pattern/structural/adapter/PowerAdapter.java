package com.yuan.design.pattern.structural.adapter;

/**
 * @ClassName PowerAdapter
 * @Author Administrator
 * @Date 2020/1/20 13:48
 */
public class PowerAdapter implements  DC5 {
    private AC220 ac220 = new AC220();
    public int outputDC5V() {
        int adapterInput = ac220.outputAC220();
        //变压器。。。
        int adapteroutput = adapterInput/44;
        System.out.println("使用PowerAdapter输入AC： "+adapterInput+"V 输出直流电DC: "+adapteroutput+ " V");
        return adapteroutput;
    }
}
