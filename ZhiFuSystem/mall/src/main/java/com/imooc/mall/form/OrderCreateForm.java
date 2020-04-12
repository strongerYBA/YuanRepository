package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @ClassName OrderCreate
 * @Author Administrator
 * @Date 2020/4/6 17:26
 */
@Data
public class OrderCreateForm {
    @NotNull
    private Integer shippingId;
}
