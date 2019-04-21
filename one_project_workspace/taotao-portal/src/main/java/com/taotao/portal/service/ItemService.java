package com.taotao.portal.service;

import com.taotao.portal.pojo.ItemInfo;

/**
 * 商品基本信息。
 * @author Administrator
 *
 */
public interface ItemService {
	ItemInfo getItemBaseInfo(long itemId);
	String getItemDesc(long itemId);
	String getItemParam(long itemId);
}
