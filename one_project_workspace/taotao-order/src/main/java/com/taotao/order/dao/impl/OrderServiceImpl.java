package com.taotao.order.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.constants.RedisConstant;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbOrderItemMapper;
import com.taotao.mapper.TbOrderMapper;
import com.taotao.mapper.TbOrderShippingMapper;
import com.taotao.order.dao.JedisClient;
import com.taotao.order.service.OrderService;
import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;
/**
 * 订单管理service。
 * @author Administrator
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TbOrderMapper tbOrderMapper;
	@Autowired
	private TbOrderItemMapper tbOrderItemMapper;
	@Autowired
	private TbOrderShippingMapper tbOrderShippingMapper;
	@Autowired
	private JedisClient jedisClient;
	@Override
	public TaotaoResult createOrder(TbOrder order, List<TbOrderItem> orderItems, TbOrderShipping orderShipping) {
		// TODO Auto-generated method stub
		//向订单表中插入记录。
		String string = jedisClient.get(RedisConstant.ORDER_KEY);
		if (StringUtils.isBlank(string)) {
			jedisClient.set(RedisConstant.ORDER_KEY, "100544");
		}
		//获得订单号。
		long orderId = jedisClient.incr(RedisConstant.ORDER_KEY);
		//补全pojo的属性。
		order.setOrderId(orderId+"");
		order.setStatus(1);//状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
		Date date  = new Date();
		order.setCreateTime(date);
		order.setUpdateTime(date);
		order.setBuyerRate(0);//0未评价。1已经评价。
		//向订单表中插入数据。
		tbOrderMapper.insert(order);
		
		//插入订单明细。
		for (TbOrderItem tbOrderItem : orderItems) {
			//补全订单明细。
			//获得订单明细id。
			long orderItemId = jedisClient.incr(RedisConstant.ORDER_ITEM_KEY);
			tbOrderItem.setId(orderItemId+"");
			tbOrderItem.setOrderId(orderId+"");
			//向订单明细表插入记录。
			tbOrderItemMapper.insert(tbOrderItem);
		}
		
		//插入物流表。
		orderShipping.setOrderId(orderId+"");
		orderShipping.setCreated(date);
		orderShipping.setUpdated(date);
		tbOrderShippingMapper.insert(orderShipping);
		return TaotaoResult.ok(orderId);
	}

}
