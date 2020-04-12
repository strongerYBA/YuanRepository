package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName UserForm
 * @Author Administrator
 * @Date 2020/3/9 17:07
 */
@Data
public class UserLoginForm {
    //    @NonNull 判断是否为null
//    @NotEmpty 判读集合。
//    @NotBlank 判读 String，是空格也会报错
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
