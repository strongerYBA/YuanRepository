package com.imooc.pay.service.impl;

import com.imooc.pay.PayApplicationTests;
import com.imooc.pay.service.IPayService;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;

import javax.annotation.Resource;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PayServiceTest  extends PayApplicationTests {
    @Resource
    private IPayService payService;
    //amqp是一种协议。
    @Resource
    private AmqpTemplate amqpTemplate;
    @Test
    public void create() {
        //BigDecimal.valueOf(0.01)(使用),new BigDecimal(0.01)(两者不等同)
        //BigDecimal.valueOf(0.01) == new BigDecimal("0.01")(传入字符串是等同的)
        payService.create("5665652", BigDecimal.valueOf(0.01), BestPayTypeEnum.WXPAY_NATIVE);
    }
    @Test
    public void sendMQMsg(){
        amqpTemplate.convertAndSend("payNotify","hello");
    }
}