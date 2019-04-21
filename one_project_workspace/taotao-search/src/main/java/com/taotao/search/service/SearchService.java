package com.taotao.search.service;

import com.taotao.search.pojo.SearchResult;

public interface SearchService {
	public SearchResult searchItem(String queryString, Integer page,Integer rows) throws Exception ;
}
