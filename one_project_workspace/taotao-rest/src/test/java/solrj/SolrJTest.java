package solrj;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * solr的测试。
 * @author Administrator
 *
 */
public class SolrJTest {
	@Test
	public void addDocument() throws SolrServerException, IOException
	{
		//创建一个练级。
		SolrServer solrServer = new HttpSolrServer("http://192.168.91.128:8080/solr");
		//创建一个文档对象。
		SolrInputDocument solrInputDocument = new SolrInputDocument();
		solrInputDocument.addField("id", "111");
		solrInputDocument.addField("item_title", "测试商品1");
		solrInputDocument.addField("item_price", 12454654);
		//写入索引库。
		solrServer.add(solrInputDocument);
		//提交。
		solrServer.commit();
	}
	
	@Test
	public void delDocument() throws SolrServerException, IOException
	{
		//创建一个练级。
		SolrServer solrServer = new HttpSolrServer("http://192.168.91.128:8080/solr");
		solrServer.deleteById("111");
		solrServer.deleteByQuery("*:*");
		//提交。
		solrServer.commit();
	}
	
}
