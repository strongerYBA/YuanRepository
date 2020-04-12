package com.yuan.design.pattern.structural.facade;

/**
 * @ClassName QualifyService
 * @Author Administrator
 * @Date 2020/1/19 13:00
 * 校验子系统。
 */
public class QualifyService {
    public boolean isAvailable(PointsGift pointsGift){
        System.out.println("校验"+pointsGift.getName()+" 积分资格通过，库存通过");
        return true;
    }
}
