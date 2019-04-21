package com.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.search.service.ItemService;

/**
 * 发布服务。索引库维护。
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manager")
public class ItemController {
	@Autowired
	private ItemService itemService;
	/**
	 * 导入商品数据到索引库。
	 * @return
	 */
	@RequestMapping("/importall")
	@ResponseBody
	public TaotaoResult importItemAll()
	{
		TaotaoResult importAllItems = itemService.importAllItems();
		return importAllItems;
	}

}
