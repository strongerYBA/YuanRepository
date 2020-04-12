package com.yuan.elasticsearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @ClassName MyConfig
 * @Author Administrator
 * @Date 2019/12/20 21:45
 */
@Configuration
public class MyConfig {
    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        //默认Es的tcp端口是9300。
        TransportAddress node = new TransportAddress(InetAddress.getByName("localhost"),9300);
        //配置。
        Settings settings = Settings.builder()
                .put("cluster.name","yuan").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        //可以添加多个节点。
        client.addTransportAddress(node);
        return client;
    }
}
