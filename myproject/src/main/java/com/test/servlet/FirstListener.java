package com.test.servlet;

import org.springframework.context.ApplicationListener;

/**
 * @ClassName FirstListener
 * @Description TODO
 * @Author dell
 * @Date 2019/4/17 15:46
 */
public class FirstListener implements ApplicationListener<MyEvent> {

    public void onApplicationEvent(MyEvent event) {
        System.out.println("接受到的事件："+event.getClass());
    }
}
