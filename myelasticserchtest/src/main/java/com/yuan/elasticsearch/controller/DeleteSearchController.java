package com.yuan.elasticsearch.controller;

import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName DeleteSearchController
 * @Author Administrator
 * @Date 2019/12/22 20:49
 */
@RestController
public class DeleteSearchController {
    @Resource
    private TransportClient client;
    @DeleteMapping("/delete/people")
    @ResponseBody
    private ResponseEntity delete(@RequestParam(name = "id")String id){
        DeleteResponse deleteResponse = this.client.prepareDelete("people02", "_doc", id).get();
        return new ResponseEntity(deleteResponse.getResult(),HttpStatus.OK);
    }
}
