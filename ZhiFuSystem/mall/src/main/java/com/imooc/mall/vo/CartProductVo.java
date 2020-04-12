package com.imooc.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName CartProductVo
 * @Author Administrator
 * @Date 2020/3/12 11:53
 */
@Data
public class CartProductVo {
    private Integer productId;
    /**
     * 购买的数量。
     */
    private Integer quantity;

    private String productName  ;

    private String productSubtitle;

    private String productMainImage;

    private BigDecimal productPrice;

    private Integer productStatus;
    /**
     * 总价=数量*单价。
     */
    private BigDecimal productTotalPrice;

    private Integer productStock;
    /**
     * 商品是否选中。
     */
    private Boolean productSelected;
    public CartProductVo(){

    }
    public CartProductVo(Integer productId, Integer quantity, String productName, String productSubtitle, String productMainImage, BigDecimal productPrice, Integer productStatus, BigDecimal productTotalPrice, Integer productStock, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.productSubtitle = productSubtitle;
        this.productMainImage = productMainImage;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.productTotalPrice = productTotalPrice;
        this.productStock = productStock;
        this.productSelected = productSelected;
    }
}
