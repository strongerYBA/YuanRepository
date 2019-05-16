package com.taotao.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.taotao.common.constants.RedisConstant;
import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService
{
	@Autowired
	private TbContentMapper tbContent;
	@Autowired
	private JedisClient jedisClient;
	@Override
	public List<TbContent> getContentList(long contentCid) {
		try {
			//从缓存中取。
			String hget = jedisClient.hget(RedisConstant.INDEX_CONTENT_REDIS_KEY, contentCid+"");
			if (!StringUtils.isEmpty(hget)) {
				List<TbContent> jsonToList = JsonUtils.jsonToList(hget, TbContent.class);
				return jsonToList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TbContentExample tbContentExample = new TbContentExample();
		Criteria createCriteria = tbContentExample.createCriteria();
		createCriteria.andCategoryIdEqualTo(contentCid);
		List<TbContent> selectByExample = tbContent.selectByExample(tbContentExample);

		try {
			//向缓存中添加。
			String objectToJson = JsonUtils.objectToJson(selectByExample);
			jedisClient.hset(RedisConstant.INDEX_CONTENT_REDIS_KEY, contentCid+"", objectToJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectByExample;
	}

}