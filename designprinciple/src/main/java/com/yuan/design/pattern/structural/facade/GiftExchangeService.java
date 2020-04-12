package com.yuan.design.pattern.structural.facade;

/**
 * @ClassName GiftExchangeService
 * @Author Administrator
 * @Date 2020/1/19 13:08
 * 外观类。
 */
public class GiftExchangeService {
    private QualifyService qualifyService = new QualifyService();
    private PointsPaymentService pointsPaymentService = new PointsPaymentService();
    private ShippingService shippingService = new ShippingService();
    public void giftExchange(PointsGift gift){
        if (qualifyService.isAvailable(gift)){
            //资格校验通过：
            if (pointsPaymentService.pay(gift)){
                //如果积分支付成功。可以返回订单号了
                String shippingOrderNo = shippingService.shipGift(gift);
                System.out.println("物流系统下单成功。订单号： "+shippingOrderNo);
            }
        }
    }
}
