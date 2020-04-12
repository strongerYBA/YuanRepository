package com.imooc.pay.service;

import com.imooc.pay.pojo.PayInfo;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;

import java.math.BigDecimal;

public interface IPayService {
    /**
     * 创建或者发起支付
     */
    PayResponse create(String orderId, BigDecimal amount, BestPayTypeEnum bestPayTypeEnum);

    String  asyncNotify(String notifyData);

    /**
     * 通过orderId查询支付状态。
     * @param orderId
     * @return
     */
    PayInfo queryOrderById(String orderId);
}
