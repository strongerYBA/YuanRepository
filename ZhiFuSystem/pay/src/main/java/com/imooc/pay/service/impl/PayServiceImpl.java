package com.imooc.pay.service.impl;

import com.google.gson.Gson;
import com.imooc.pay.dao.PayInfoMapper;
import com.imooc.pay.enums.PayPlatformEnum;
import com.imooc.pay.pojo.PayInfo;
import com.imooc.pay.service.IPayService;
import com.lly835.bestpay.enums.BestPayPlatformEnum;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.enums.OrderStatusEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Slf4j
@Service
public class PayServiceImpl implements IPayService {
    public static final String QUEUE_PAY_NOTIFY = "payNotify";
    //    将BestPayService抽取出来，形成配置文件，以供全局调用
    @Resource
    private BestPayService bestPayService;

    @Resource
    private PayInfoMapper payInfoMapper;

    @Resource
    private AmqpTemplate amqpTemplate;
    /**
     * 创建或者发起支付
     */
    @Override
    public PayResponse create(String orderId, BigDecimal amount,BestPayTypeEnum bestPayTypeEnum){

//        /写入数据库
        PayInfo payInfo = new PayInfo(Long.parseLong(orderId),
                PayPlatformEnum.getByBestPayTypeEnum(bestPayTypeEnum).getCode(),
                OrderStatusEnum.NOTPAY.name(),
                amount);
        payInfoMapper.insertSelective(payInfo);
//        2、发起支付
        PayRequest request = new PayRequest();
        request.setOrderName("7491209-最好的支付SDK");
        request.setOrderId(orderId);
        request.setOrderAmount(amount.doubleValue());
        request.setPayTypeEnum(bestPayTypeEnum);

        PayResponse response = bestPayService.pay(request);
        log.info("发起支付【response】={}",response);
//        3、异步回调
//        bestPayService.asyncNotify()

        return response;
    }

    /**
     * 异步通知处理。
     * @param notifyData
     */
    @Override
    public String asyncNotify(String notifyData) {
//        1、签名校验
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("异步通知【payResponse】 = {}",payResponse);
//        2、金额校验（从数据库查订单）数据库的金额和异步通知的金额做校验。
//        比较严重，（正常情况下是不会发生的）发出告警：钉钉，短信。短信
        PayInfo payInfo = payInfoMapper.selectByOrderNo(Long.parseLong(payResponse.getOrderId()));
        if (payInfo==null){
//            发出告警：钉钉，短信。短信
            throw new RuntimeException("通过OrderId查询到的结果是null");
        }
        //判断支付状态。如果订单支付状态不是“已支付”
        if (!payInfo.getPlatformStatus().equals(OrderStatusEnum.SUCCESS.name())){
//                  BigDecimal类型的比较：
//                  @return -1, 0, or 1 as this {@code BigDecimal} is numerically
//                  less than, equal to, or greater than {@code val
//            double类型比较大小，精度。1.00 1.0
            if (payInfo.getPayAmount().compareTo(BigDecimal.valueOf(payResponse.getOrderAmount()))!=0){
//                发出告警：钉钉，短信。短信
                throw new RuntimeException("异步通知中的金额和数据库里的不一致,OrderNo= "+payResponse.getOrderId());
            }
//        3、修改订单支付状态，金额一致。
            payInfo.setPlatformStatus(OrderStatusEnum.SUCCESS.name());
            //交易流水号
            payInfo.setPlatformNumber(payResponse.getOutTradeNo());
            //更新时间。
            payInfoMapper.updateByPrimaryKeySelective(payInfo);

        }
        //TODO（标记）  pay系统发送MQ消息，Mall系统接收MQ消息。
        amqpTemplate.convertAndSend(QUEUE_PAY_NOTIFY,new Gson().toJson(payInfo));

//        4、告诉微信，我已成功接收通知，不需再次通知（不要重复通知）
        if (payResponse.getPayPlatformEnum() == BestPayPlatformEnum.ALIPAY){
            return "success";
        }else if (payResponse.getPayPlatformEnum() == BestPayPlatformEnum.WX) {
            return "<xml>\n" +
                    "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                    "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                    "</xml>";
        }
        throw new RuntimeException("异步通知中错误的支付平台");
    }

    @Override
    public PayInfo queryOrderById(String orderId) {
        return payInfoMapper.selectByOrderNo(Long.parseLong(orderId));
    }
}
