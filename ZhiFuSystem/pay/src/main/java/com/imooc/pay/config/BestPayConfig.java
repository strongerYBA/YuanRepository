package com.imooc.pay.config;

import com.lly835.bestpay.config.AliPayConfig;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName BestPayConfig
 * @Author Administrator
 * @Date 2020/3/7 18:46
 */
@Component
public class BestPayConfig {
    @Resource
    private WxAccountConfig wxAccountConfig;
    @Resource
    private AliAccountConfig aliAccountConfig;
    @Bean
    public BestPayService bestPayService(WxPayConfig wxPayConfig){

        AliPayConfig aliPayConfig = new AliPayConfig();
        aliPayConfig.setAppId(aliAccountConfig.getAppId());
        aliPayConfig.setPrivateKey(aliAccountConfig.getPrivateKey());
        aliPayConfig.setAliPayPublicKey(aliAccountConfig.getAliPayPublicKey());
        aliPayConfig.setNotifyUrl(aliAccountConfig.getNotifyUrl());
        aliPayConfig.setReturnUrl(aliAccountConfig.getReturnUrl());

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);
        bestPayService.setAliPayConfig(aliPayConfig);
        return bestPayService;
    }
    @Bean
    public WxPayConfig wxPayConfig() {
        //        1、配置
        WxPayConfig wxPayConfig = new WxPayConfig();
//        Native支付，是需要公众账号的appid
        wxPayConfig.setAppId(wxAccountConfig.getAppId());
//        商户id
        wxPayConfig.setMchId(wxAccountConfig.getMchId());
//        商户密钥
        wxPayConfig.setMchKey(wxAccountConfig.getMchKey());
//        接收支付平台的异步通知.127.0.0.1是内网ip，不行的。需要外网ip。
//        192.168.50.101也不行，这是局域网，通俗讲，就是其他人和我连在同一个路由器下，同一局域网可以访问
//        125.121.56.227公网ip，也不能访问，家庭宽带不行（云服务器公网ip可行）
//        采用内网穿透，natapp.cn，客户端可以搞定
        wxPayConfig.setNotifyUrl(wxAccountConfig.getNotifyUrl());
//        微信支付完成后返回地址
        wxPayConfig.setReturnUrl(wxAccountConfig.getReturnUrl());
        return wxPayConfig;
    }
}
