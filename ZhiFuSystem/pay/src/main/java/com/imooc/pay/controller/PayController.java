package com.imooc.pay.controller;

import com.imooc.pay.pojo.PayInfo;
import com.imooc.pay.service.impl.PayServiceImpl;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PayController
 * @Author Administrator
 * @Date 2020/3/6 13:00
 */
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {
    @Resource
    private PayServiceImpl payService;
    @Resource
    private WxPayConfig wxPayConfig;
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("amount") BigDecimal amount,
                               @RequestParam("payType")BestPayTypeEnum bestPayTypeEnum){
        PayResponse payResponse = payService.create(orderId, amount,bestPayTypeEnum);
        String codeUrl = payResponse.getCodeUrl();
        //支付方式不同，渲染就不同，WXPAY_NATIVE使用codeUrl，ALIPAY_PC使用body
        Map<String,String> map = new HashMap();
        if (bestPayTypeEnum == BestPayTypeEnum.WXPAY_NATIVE){
            map.put("codeUrl",codeUrl);
            map.put("orderId",orderId);
            map.put("returnUrl",wxPayConfig.getReturnUrl());
            return new ModelAndView("createForWXNative",map);
        }else if (bestPayTypeEnum == BestPayTypeEnum.ALIPAY_PC){
            map.put("body",payResponse.getBody());
            return new ModelAndView("createForAliPayPc",map);
        }
        throw new RuntimeException("暂不支持该支付类型");
    }
    @PostMapping("/notify")
    @ResponseBody
    public String  asyncNotify(@RequestBody String notifyData){
        return payService.asyncNotify(notifyData);
    }

    @GetMapping("/queryOrderById")
    @ResponseBody
    public PayInfo queryOrderById(@RequestParam String orderId){
        log.info("查询支付记录。。。");
        return payService.queryOrderById(orderId);
    }
}
