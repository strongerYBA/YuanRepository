package com.yuan.elasticsearch.controller;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MutilSearchController
 * @Author Administrator
 * @Date 2019/12/22 21:19
 */
@RestController
public class MultiSearchController {
    @Resource
    private TransportClient client;
    @PostMapping("/multisearch/people")
    @ResponseBody
    public ResponseEntity multiSearch(@RequestParam(value = "name",required = false)String name,
                                      @RequestParam(value = "text",required = false)String text,
                                      @RequestParam(value = "date",required = false)
                                      @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date date,
                                      @RequestParam(name="gt_word_count",defaultValue = "0")int gtWordCount,
                                      @RequestParam(value = "lt_word_count",required = false)Integer ltWordCount) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (name!=null) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("name",name));
        }
        if (text!=null){
            boolQueryBuilder.must(QueryBuilders.matchQuery("text",text));
        }
        if (date!=null){
            boolQueryBuilder.must(QueryBuilders.matchQuery("date",date.getTime()));
        }
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("date")
                .from(gtWordCount);
        if (ltWordCount!=null && ltWordCount>0){
            rangeQueryBuilder.to(ltWordCount);
        }
        //filter
        boolQueryBuilder.filter(rangeQueryBuilder);
        SearchRequestBuilder searchRequestBuilder = this.client.prepareSearch("people02")
                .setTypes("_doc")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(boolQueryBuilder)
                .setFrom(0)
                .setSize(10);
        System.out.println(searchRequestBuilder);//查看请求体。
        SearchResponse searchResponse = searchRequestBuilder.get();
        List<Map<String,Object>> mapList = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits()) {
            mapList.add(hit.getSourceAsMap());
        }
        return new ResponseEntity(mapList, HttpStatus.OK);
    }
}
