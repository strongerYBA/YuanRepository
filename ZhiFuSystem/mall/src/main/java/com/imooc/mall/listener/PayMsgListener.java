package com.imooc.mall.listener;

import com.google.gson.Gson;
import com.imooc.mall.pojo.PayInfo;
import com.imooc.mall.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 关于PayInfo ，正确姿势：pay项目提供client.jar，mall项目引用jar包即可。而不是新建。
 * 《springcloud微服务实战》
 * @ClassName PayMsgListener
 * @Author Administrator
 * @Date 2020/4/6 18:23
 */
@Component
@RabbitListener(queues = "payNotify")
@Slf4j
public class PayMsgListener {
    @Resource
    private AmqpTemplate amqpTemplate;
    @Resource
    private IOrderService orderService;

    @RabbitHandler
    public void process(String msg){
    log.info("接收到消息 = {}",msg);
        PayInfo payInfo = new Gson().fromJson(msg, PayInfo.class);
        if (payInfo.getPlatformStatus().equals("SUCCESS")){
            //修改订单里的状态。
            orderService.paid(payInfo.getOrderNo());
        }
    }
}
