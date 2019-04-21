package com.taotao.search.pojo;

import org.apache.solr.client.solrj.SolrQuery;

public interface ItemSearchDao {
	public SearchResult searchItem(SolrQuery solrQuery) throws Exception;
}
