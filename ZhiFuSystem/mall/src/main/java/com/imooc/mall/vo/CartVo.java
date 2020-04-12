package com.imooc.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车
 * @ClassName CartVo
 * @Author Administrator
 * @Date 2020/3/12 11:52
 */
@Data
public class CartVo {
    private List<CartProductVo> CartProductVoList;
    private Boolean selectedAll;
    private BigDecimal cartTotalPrice;
    private Integer cartTotalQuantity;
}
