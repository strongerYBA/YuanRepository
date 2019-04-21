package com.taotao.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
/**
 * 订单controller。
 * @author Administrator
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.order.pojo.Order;
import com.taotao.order.service.OrderService;
@Controller
public class OrderServiceController {
	@Autowired
	private OrderService orderService;
	@RequestMapping(value ="/create",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createOrder(@RequestBody Order order)//@RequestBody注解将json字符串转换成pojo。
	{
		try {
			TaotaoResult createOrder = orderService.createOrder(order, order.getOrderItems(), order.getOrderShipping());
			return createOrder;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return TaotaoResult.build(500,ExceptionUtil.getStackTrace(e));
		}
		
	}
}
