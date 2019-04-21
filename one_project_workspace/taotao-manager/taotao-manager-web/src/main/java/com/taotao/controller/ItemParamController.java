package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController
{
	@Autowired
	private ItemParamService itemParamService;
	/**
	 * 查询商品规格参数。
	 * @param cid
	 * @return
	 */
	@RequestMapping("/query/itemcatid/{itemcatid}")
	@ResponseBody
	public TaotaoResult getItemParamByCid(@PathVariable Long  itemcatid)
	{
		TaotaoResult itemParamByCid = itemParamService.getItemParamByCid(itemcatid);
		return itemParamByCid;
	}
	/**
	 * 保存规格参数。
	 * @param itemcatid
	 * @return
	 */
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult insertItemParam(@PathVariable Long  cid,String paramData)
	{
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		TaotaoResult insertItemParam = itemParamService.insertItemParam(itemParam);
		return insertItemParam;
	}
}
