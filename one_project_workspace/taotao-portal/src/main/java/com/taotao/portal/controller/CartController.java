package com.taotao.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;

/**
 * 购物车controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired 
	private CartService cartService;

	@RequestMapping("/add/{itemId}")
	public String addCartItem(@PathVariable long itemId,
			@RequestParam(defaultValue = "1")Integer num,
			HttpServletRequest request,HttpServletResponse response)
	{
		cartService.addCartItem(request, response, itemId, num);
		return "redirect:/cart/success.html";//重定向跳转。跳转到另外一个页面。防止刷新。数量增加一。使用绝对路径。

	}
	@RequestMapping("/success")
	public String showCart(){
		return "cartSuccess";
	}
	@RequestMapping("/cart")
	public String getCartItemList(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		List<CartItem> cartItemList = cartService.getCartItemList(request, response);
		model.addAttribute("cartList", cartItemList);
		return "cart";
	}
	@RequestMapping("/delete/{itemId}")
	public String deleteCartItem(@PathVariable long itemId,
			HttpServletRequest request ,HttpServletResponse response)
	{
		cartService.deleteCartItem(itemId, request, response);
		return "redirect:/cart/cart.html";
	}
}
