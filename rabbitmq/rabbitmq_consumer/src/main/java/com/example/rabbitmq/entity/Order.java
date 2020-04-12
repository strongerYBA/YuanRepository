package com.example.rabbitmq.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
public class Order implements Serializable {
    private String id;
    private String name;
    private String messageId;
    /**这个messagId存储消息发送的唯一标识。**/
    public Order() {
    }
    public Order(String id, String name, String messageId) {
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }
}
