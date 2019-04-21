package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.rest.service.ItemService;
/**
 * 商品信息controller。
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	@RequestMapping("/info/{itemId}")
	@ResponseBody
	public TaotaoResult getItemBaseInfo(@PathVariable long itemId)
	{
		TaotaoResult itemBaseInfo = itemService.getItemBaseInfo(itemId);
		return itemBaseInfo;

	}
	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public TaotaoResult getItemDesc(@PathVariable long itemId)
	{
		TaotaoResult itemDesc = itemService.getItemDesc(itemId);
		return itemDesc;

	}
	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public TaotaoResult getItemParam(@PathVariable long itemId)
	{
		TaotaoResult itemDesc = itemService.getItemParam(itemId);
		return itemDesc;

	}
}
