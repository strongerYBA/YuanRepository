package com.yuan.elasticsearch.controller;

import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
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
 * @ClassName UpdateSearchController
 * @Author Administrator
 * @Date 2019/12/22 20:56
 */
@RestController
public class UpdateSearchController {
    @Resource
    private TransportClient client;
    @PostMapping("/update/people")
    @ResponseBody
    private ResponseEntity update(@RequestParam("id")String id,
                                  @RequestParam(value = "name",required = false)String name,
                                  @RequestParam(value = "text",required = false)String text,
                                  @RequestParam(value = "date",required = false)
                                  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date date) {
        UpdateRequest updateRequest = new UpdateRequest("people02","_doc",id);
        try {
            XContentBuilder content = XContentFactory.jsonBuilder()
                    .startObject();
            if (name != null){
                content.field("name",name);
            }
            if (text!=null){
                content.field("text",text);
            }
            if (date!=null){
                content.field("date",date.getTime());
            }
            content.endObject();
            updateRequest.doc(content);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            UpdateResponse updateResponse = this.client.update(updateRequest).get();
            return new ResponseEntity(updateResponse.getResult(),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
