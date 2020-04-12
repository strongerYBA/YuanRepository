package com.yuan.design.pattern.structural.facade;

/**
 * @ClassName PointsPaymentService
 * @Author Administrator
 * @Date 2020/1/19 13:03
 * 支付子系统。
 */
public class PointsPaymentService {
    public boolean pay(PointsGift gift){
         //扣减积分。
        System.out.println("支付"+gift.getName()+" 积分成功");
        return true;
    }
}
