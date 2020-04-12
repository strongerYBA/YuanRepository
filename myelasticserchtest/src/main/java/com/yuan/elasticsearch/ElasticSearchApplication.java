package com.yuan.elasticsearch;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName com.yuan.elasticsearch.ElasticSearchApplication
 * @Author Administrator
 * @Date 2019/12/18 22:13
 */
@SpringBootApplication
@RestController
public class ElasticSearchApplication {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication.class,args);
    }
}
