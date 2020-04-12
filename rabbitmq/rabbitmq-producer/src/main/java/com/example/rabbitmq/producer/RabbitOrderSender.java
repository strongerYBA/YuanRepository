package com.example.rabbitmq.producer;

import com.example.rabbitmq.entity.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitOrderSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void sendOrder(Order order)throws Exception{
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());
        rabbitTemplate.convertAndSend("order-exchange",//exchange
                "order.abcd", //routing key
                order,//消息体内容
                correlationData);//correlationData 消息的唯一id。
    }
}
