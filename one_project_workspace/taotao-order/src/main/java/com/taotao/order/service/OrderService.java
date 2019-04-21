package com.taotao.order.service;

import java.util.List;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;

public interface OrderService {
	TaotaoResult createOrder(TbOrder order,List<TbOrderItem> orderItems,TbOrderShipping orderShipping);
}
