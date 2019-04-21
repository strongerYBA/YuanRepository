package com.taotao.portal.controller;

import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.common.utils.ExceptionUtil;
import com.taotao.pojo.TbUser;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.pojo.Order;
import com.taotao.portal.service.CartService;
import com.taotao.portal.service.OrderService;

/**
 * 订单controller。
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController
{
	private Logger Log = Logger.getLogger(OrderController.class);
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	@RequestMapping("/order-cart")
	public String showOrderCart(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		List<CartItem> cartItemList = cartService.getCartItemList(request, response);
		model.addAttribute("cartList", cartItemList);
		return "order-cart";
	}
	@RequestMapping("/create")
	public  String orderCreate(Order order,Model model,HttpServletRequest request)
	{
		Log.error("获取 Order-cart的路径信息。request.getRequestURL()="+request.getRequestURL()+",request.getRequestURI()="
				+request.getRequestURI());
		try {
			//从request中取用户信息。在拦截器中获取用户信息。传过来的。
			TbUser user = (TbUser) request.getAttribute("user");
			order.setUserId(user.getId());
			order.setBuyerNick(user.getUsername());
			String createOrder = orderService.createOrder(order);
			model.addAttribute("orderId", createOrder);	
			model.addAttribute("payment", order.getPayment());
			model.addAttribute("date", new DateTime().plusDays(3).toString("yyyy-MM-dd"));
			return "success";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "订单出错，请稍后重试！！！");
			return "error/exception";
		}

	}
}
