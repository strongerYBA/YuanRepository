package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.service.ItemParamItemService;
/**
 * 展示商品规格参数。返回一个jsp页面。item.jsp
 * @author Administrator
 *
 */
@Controller
public class ItemParamItemController {
	@Autowired
	private ItemParamItemService itemParamItemService;
	@RequestMapping("/showitem/{itemId}")
	public String showItemParam(@PathVariable long itemId,Model model)
	{
		String itemParamById = itemParamItemService.getItemParamById(itemId);
		model.addAttribute("itemParam", itemParamById);
		return "item";
		
	}
}
