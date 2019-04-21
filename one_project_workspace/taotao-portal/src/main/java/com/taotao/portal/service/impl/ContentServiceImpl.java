package com.taotao.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.portal.service.ContentService;
/**
 * 调用服务层服务。
 * @author Administrator
 *
 */
@Service
public class ContentServiceImpl implements ContentService {
	private Logger Log = Logger.getLogger(ContentServiceImpl.class);
	@Override
	public String getContentList() {
		try {
			String doGet = HttpClientUtil.doGet("http://localhost:8082/rest/content/list/89");
			Log.error(doGet);
			TaotaoResult formatToList = TaotaoResult.formatToList(doGet, TbContent.class);
			Log.error(formatToList);
			List<TbContent> data = (List<TbContent>) formatToList.getData();
			Log.error(data);
			List<Map> resultList = new ArrayList<>();
			for (TbContent tbContent : data) {
				Map mapp = new HashMap<>();
				mapp.put("src", tbContent.getPic());
				mapp.put("height", 240);
				mapp.put("width", 670);
				mapp.put("srcB", tbContent.getPic2());
				mapp.put("widthB", 550);
				mapp.put("heightB", 240);
				mapp.put("href", tbContent.getUrl());
				mapp.put("alt", tbContent.getSubTitle());
				resultList.add(mapp);
			}
			return JsonUtils.objectToJson(resultList);
			
		} catch (Exception e) {
			Log.error("打广告位，商品展示失败！！！");
		}
		return null;
	}

}
