package com.imooc.mall.pojo;

import lombok.Data;

/**
 * @ClassName Cart
 * @Author Administrator
 * @Date 2020/3/13 14:50
 */
@Data
public class Cart {
    private Integer productId;
    /**
     * 购买的数量。
     */
    private Integer quantity;
    /**
     * 商品是否选中。
     */
    private Boolean productSelected;

    public Cart() {
    }

    public Cart(Integer productId, Integer quantity, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }
}
