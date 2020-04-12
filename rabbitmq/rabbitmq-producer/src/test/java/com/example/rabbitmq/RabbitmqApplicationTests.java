package com.example.rabbitmq;

import com.example.rabbitmq.entity.Order;
import com.example.rabbitmq.producer.RabbitOrderSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class RabbitmqApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private RabbitOrderSender orderSender;
	@Test
	public void testSend() throws Exception {
		Order order = new Order();
		order.setId("aaa");
		order.setName("袁");
		order.setMessageId(System.currentTimeMillis()+"$"+ UUID.randomUUID().toString());
		orderSender.sendOrder(order);
	}
}
