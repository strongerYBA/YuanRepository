package com.taotao.rest.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.logging.Log;
import com.taotao.common.constants.RedisConstant;
import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.pojo.TbItemParamItemExample.Criteria;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ItemService;
/**
 * 查询商品信息。
 * @author Administrator
 *
 */
@Service
public class ItemServiceImpl implements ItemService{
	private Logger Log = Logger.getLogger(ItemServiceImpl.class);

	@Autowired
	private TbItemMapper tbItemMapper;
	@Autowired
	private JedisClient jedisClient;
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	@Autowired
	private TbItemParamItemMapper tbItemParamItemMapper;
	@Override
	public TaotaoResult getItemBaseInfo(long itemId) {
		//添加缓存逻辑。
		//取缓存。
		try {
			String string = jedisClient.get(RedisConstant.ITEM_REDIS_KEY+":"+itemId+":base");
			if (!string.isEmpty()) {
				TbItem jsonToPojo = JsonUtils.jsonToPojo(string, TbItem.class);
				return TaotaoResult.ok(jsonToPojo);
			}
		} catch (Exception e) {
			Log.error("Get redis cache is null");
		}
		TbItem selectByPrimaryKey = tbItemMapper.selectByPrimaryKey(itemId);
		//写入缓存。设置key的有效期。redis中hash不能设置过期时间。
		try {
			jedisClient.set(RedisConstant.ITEM_REDIS_KEY+":"+itemId+":base",
					JsonUtils.objectToJson(selectByPrimaryKey));
			//设置过期时间。
			jedisClient.expire(RedisConstant.ITEM_REDIS_KEY+":"+itemId+":base",
					RedisConstant.ITEM_REDIS_KEY_EXPIRE);
		} catch (Exception e) {
			Log.error("Insert redis is failed ...");
		}
		return TaotaoResult.ok(selectByPrimaryKey);
	}
	/**
	 * 获取商品描述信息。
	 */
	@Override
	public TaotaoResult getItemDesc(long itemId) {
		//添加缓存逻辑。
		//取缓存。
		try {
			String string = jedisClient.get(RedisConstant.ITEM_REDIS_KEY+":"+itemId+":desc");
			if (!string.isEmpty()) {
				TbItemDesc jsonToPojo = JsonUtils.jsonToPojo(string, TbItemDesc.class);
				return TaotaoResult.ok(jsonToPojo);
			}
		} catch (Exception e) {
			Log.error("Get redis cache is null");
		}
		TbItemDesc selectByPrimaryKey = tbItemDescMapper.selectByPrimaryKey(itemId);
		//写入缓存。设置key的有效期。redis中hash不能设置过期时间。
		try {
			jedisClient.set(RedisConstant.ITEM_REDIS_KEY+":"+itemId+":desc",
					JsonUtils.objectToJson(selectByPrimaryKey));
			//设置过期时间。
			jedisClient.expire(RedisConstant.ITEM_REDIS_KEY+":"+itemId+":desc",
					RedisConstant.ITEM_REDIS_KEY_EXPIRE);
		} catch (Exception e) {
			Log.error("Insert redis is failed ...");
		}
		return TaotaoResult.ok(selectByPrimaryKey);
	}
	/**
	 * 查询商品规格参数。
	 */
	@Override
	public TaotaoResult getItemParam(long itemId) {
		// TODO Auto-generated method stub
		//取缓存。
		try {
			String string = jedisClient.get(RedisConstant.ITEM_REDIS_KEY+":"+itemId+":param");
			if (!string.isEmpty()) {
				TbItemParamItem jsonToPojo = JsonUtils.jsonToPojo(string, TbItemParamItem.class);
				return TaotaoResult.ok(jsonToPojo);
			}
		} catch (Exception e) {
			Log.error("Get redis cache is null");
		}
		TbItemParamItemExample example = new TbItemParamItemExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andItemIdEqualTo(itemId);
		List<TbItemParamItem> selectByExampleWithBLOBs = tbItemParamItemMapper.selectByExampleWithBLOBs(example);
		if (!selectByExampleWithBLOBs.isEmpty()&&selectByExampleWithBLOBs.size()>0) {
			TbItemParamItem tbItemParamItem = selectByExampleWithBLOBs.get(0);
			//写入缓存。设置key的有效期。redis中hash不能设置过期时间。
			try {
				jedisClient.set(RedisConstant.ITEM_REDIS_KEY+":"+itemId+":param",
						JsonUtils.objectToJson(tbItemParamItem));
				//设置过期时间。
				jedisClient.expire(RedisConstant.ITEM_REDIS_KEY+":"+itemId+":param",
						RedisConstant.ITEM_REDIS_KEY_EXPIRE);
			} catch (Exception e) {
				Log.error("Insert redis is failed ...");
			}
			return TaotaoResult.ok(tbItemParamItem);
		}
		return TaotaoResult.build(400, "无此商品信息！！！");
	}

}
