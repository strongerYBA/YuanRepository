package com.yuan.design.pattern.structural.facade;

/**
 * @ClassName ShippingService
 * @Author Administrator
 * @Date 2020/1/19 13:05
 * 物流子系统。
 */
public class ShippingService {
    public String shipGift(PointsGift gift){
         //物流系统的对接逻辑。
        System.out.println(gift.getName()+"进入物流系统：");
        String shippingOrderNo = "55";
        return shippingOrderNo;
    }
}
