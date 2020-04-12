package com.yuan.elasticsearch.controller;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName AddSearchController
 * @Author Administrator
 * @Date 2019/12/22 20:29
 */
@RestController
public class AddSearchController {
    @Resource
    private TransportClient client;
    @PostMapping("/add/people")
    @ResponseBody
    public ResponseEntity add(@RequestParam(name = "name")String name,
                              @RequestParam(name = "text")String text,
                              @RequestParam(name = "date")
                              @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        try {
            //构造Es文档，ES中自带的构造工具。
            XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("name", name)
                    .field("text", text)
                    .field("date", date.getTime())
                    .endObject();
            //添加。
            IndexResponse indexResponse = this.client.prepareIndex("people02", "_doc").setSource(xContentBuilder).get();
            return new ResponseEntity(indexResponse.getId(),HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
