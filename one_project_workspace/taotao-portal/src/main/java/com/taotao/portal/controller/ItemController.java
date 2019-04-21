package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.portal.pojo.ItemInfo;
import com.taotao.portal.service.ItemService;

/**
 * 商品详情页面展示。
 * @author Administrator
 *
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	/**
	 * 展示商品详情。
	 * @param itemId
	 * @param model
	 * @return
	 */
	@RequestMapping("/item/{itemId}")
	public String showItem(@PathVariable Long itemId,Model model)
	{
		ItemInfo itemBaseInfo = itemService.getItemBaseInfo(itemId);
		model.addAttribute("item", itemBaseInfo);
		return "item";
	}
	/**
	 * 展示商品描述。
	 * @param itemId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/item/desc/{itemId}",produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	public String showDesc(@PathVariable Long itemId,Model model)
	{
		String itemBaseInfo = itemService.getItemDesc(itemId);
		return itemBaseInfo;
	}
	/**
	 * 展示商品规格参数。
	 * @param itemId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/item/param/{itemId}",produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	public String showParam(@PathVariable Long itemId,Model model)
	{
		String itemBaseInfo = itemService.getItemParam(itemId);
		return itemBaseInfo;
	}
}
