package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.NoSuccessedException;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
@Controller
public class ItemController 
{
	@Autowired
	private ItemService itemService;
	//返回json对象。
	/**
	 * 通过ID获取item.
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long itemId)
	{
		TbItem itemById = itemService.getItemById(itemId);
		return itemById;
	}
	/**
	 * 查询商品列表。
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(int page ,int rows)
	{
		EUDataGridResult itemList = itemService.getItemList(page, rows);
		return itemList;
	}
	/**
	 * 添加商品。
	 * @param item
	 * @return
	 * @throws NoSuccessedException 
	 */
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult creatItem(TbItem item,String desc,String itemParams) throws NoSuccessedException
	{
		TaotaoResult creatItem = itemService.creatItem(item ,desc,itemParams	);
		return creatItem;	
	}
}
