package com.imooc.mall.exception;

/**
 * @ClassName UserLoginException
 * @Author Administrator
 * @Date 2020/3/10 14:41
 */
public class UserLoginException extends RuntimeException {
    public UserLoginException(String language) {
        super(language);
    }
}
