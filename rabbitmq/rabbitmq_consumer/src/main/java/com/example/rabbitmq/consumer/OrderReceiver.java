package com.example.rabbitmq.consumer;

import com.example.rabbitmq.entity.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderReceiver {
    @RabbitListener(bindings =@QueueBinding(
            value = @Queue(value = "order-queue",durable = "true"),
            exchange = @Exchange(value = "order-exchange",durable = "true",type = "topic"),
            key = "order.*"
    ))
    @RabbitHandler
    public void onOrderMessage(@Payload Order order, @Headers Map<String,Object> headers, Channel channel)
            throws Exception{
        System.out.println("收到消息，开始消费！");
        System.out.println("订单id："+order.getId());
        System.out.println("名称："+order.getName());
        long d = (long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //手工签收，消费完成后会告诉rabbitmq已经消费完成。
        channel.basicAck(d,false);
    }

}
