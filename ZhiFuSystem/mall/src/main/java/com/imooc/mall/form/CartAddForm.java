package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 添加商品
 * @ClassName CartAddForm
 * @Author Administrator
 * @Date 2020/3/12 12:13
 */
@Data
public class CartAddForm {
    @NotNull
    private Integer productId;
    private Boolean selected = true;

}
