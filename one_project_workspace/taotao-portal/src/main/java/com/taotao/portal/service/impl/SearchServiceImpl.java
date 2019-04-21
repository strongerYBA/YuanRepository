package com.taotao.portal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.taotao.common.constants.SolrConstant;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.portal.pojo.SearchResult;
import com.taotao.portal.service.SearchService;
@Service
public class SearchServiceImpl implements SearchService {

	public SearchResult search(String queryString, int page) {
		// TODO Auto-generated method stub
		//查询参数。
		Map<String ,String > map = new HashMap<>();
		map.put("q", queryString);
		map.put("page",  page+"");
		//调用taotao-search 服务。
		try {
			String doGet = HttpClientUtil.doGet(SolrConstant.SEARCH_URL,map);
			TaotaoResult formatToPojo = TaotaoResult.formatToPojo(doGet, SearchResult.class);
			if (formatToPojo.getStatus() == 200) {

				SearchResult data = (SearchResult) formatToPojo.getData();
				return data;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
