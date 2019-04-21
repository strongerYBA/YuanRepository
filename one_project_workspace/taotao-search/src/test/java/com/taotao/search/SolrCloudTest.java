package com.taotao.search;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrCloudTest {
	@Test
	public void testAddDocument()throws Exception
 	{
			//创建solr集群的链接。
		CloudSolrServer solrServer = new CloudSolrServer("192.168.91.128:2181,192.168.91.128:2182,192.168.91.128:2183");
		//设置默认的collection
		solrServer.setDefaultCollection("collection2");
		//创建一个文档对象。
		SolrInputDocument inputDocument = new SolrInputDocument();
		//向文档中添加域。
		inputDocument.addField("id", "yuantest001");
		inputDocument.addField("item_title", "测试商品");
		//把文档添加索引库。
		solrServer.add(inputDocument);
		//提交。
		solrServer.commit();
		
	}
	@Test
	public void deleteDocu() throws SolrServerException, IOException
	{
		//创建solr集群的链接。
		CloudSolrServer solrServer = new CloudSolrServer("192.168.91.128:2181,192.168.91.128:2182,192.168.91.128:2183");
		//设置默认的collection
		solrServer.setDefaultCollection("collection2");
		//删除。
		solrServer.deleteByQuery("*:*");
		//提交。
		solrServer.commit();
	}
}
