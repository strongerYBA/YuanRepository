package com.test.servlet;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName MyEvent
 * @Description TODO
 * @Author dell
 * @Date 2019/4/17 15:57
 */
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
    }
}
