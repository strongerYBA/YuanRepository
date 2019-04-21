package com.taotao.portal.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.taotao.common.constants.HttpClientConstant;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.portal.pojo.Order;
import com.taotao.portal.service.OrderService;
/**
 * 订单服务。
 * @author Administrator
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	private Logger Log = Logger.getLogger(OrderServiceImpl.class);
	@Override
	public String createOrder(Order order) {
		//创建order之前就应该吧用户信息补全。
		//从cookie中获取TT_TOKEN的内容。根据token调用sso系统 获取用户信息。

		// TODO Auto-generated method stub
		String json = HttpClientUtil.doPostJson(HttpClientConstant.ORDER_CREATE_URL, JsonUtils.objectToJson(order));
		//将json转换成TaotaoResult。
		TaotaoResult format = TaotaoResult.format(json);
		if (format.getStatus() == 200) {
			String orderId = format.getData().toString();
			return orderId;
		}

		return "";
	}

}
