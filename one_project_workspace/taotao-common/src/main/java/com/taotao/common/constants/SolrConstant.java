package com.taotao.common.constants;

public class SolrConstant {
	//访问solr页面。路径。
	public static final String SOLR_URL = "http://192.168.91.128:8080/solr";
	//搜索服务url
		public static final String SEARCH_URL = "http://192.168.91.128:8084/search/query";
	//搜索服务url
//	public static final String SEARCH_URL = "http://search.taotao.com/search/query";
	/**
	 * solr集群中zookeeper的地址。
	 * 
	 */
	public static final String ZOOKEEPER_URL = "192.168.91.128:2181,192.168.91.128:2182,192.168.91.128:2183";
}
