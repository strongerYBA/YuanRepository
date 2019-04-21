package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.NoSuccessedException;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * 查詢 商品信息。
 * @author Administrator
 */
public interface ItemService 
{
	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page,int rows);
	TaotaoResult creatItem(TbItem item,String desc,String itemParam)throws NoSuccessedException;
}
