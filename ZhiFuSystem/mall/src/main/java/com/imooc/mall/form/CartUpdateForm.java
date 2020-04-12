package com.imooc.mall.form;

import lombok.Data;

/**
 * @ClassName CartUpdateForm
 * @Author Administrator
 * @Date 2020/3/13 22:24
 */
@Data
public class CartUpdateForm {
    //由于都是非必填，所以表单都不用校验了。
    private Integer quantity;
    private Boolean selected;

}
