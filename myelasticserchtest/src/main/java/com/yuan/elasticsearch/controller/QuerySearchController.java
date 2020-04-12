package com.yuan.elasticsearch.controller;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SearchController
 * @Author Administrator
 * @Date 2019/12/20 21:mv
 */
@RestController
public class QuerySearchController {
    @Autowired
    private TransportClient client;
    @GetMapping("/get/people")
    @ResponseBody
    public ResponseEntity get(@RequestParam(name = "id",defaultValue = "")String id) {
        if (id.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        GetResponse result = this.client.prepareGet("people02","_doc",id).get();
        if (!result.isExists()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result.getSource(), HttpStatus.OK);
    }
}
