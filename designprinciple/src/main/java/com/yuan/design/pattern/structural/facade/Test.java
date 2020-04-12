package com.yuan.design.pattern.structural.facade;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/19 13:18
 */
public class Test {
    public static void main(String[] args) {
        PointsGift gift = new PointsGift("T恤");
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        giftExchangeService.giftExchange(gift);

    }
}
