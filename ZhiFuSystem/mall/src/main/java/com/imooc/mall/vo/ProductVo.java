package com.imooc.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName ProductVo
 * @Author Administrator
 * @Date 2020/3/11 19:35
 */
@Data
public class ProductVo {

    private Integer id;

    private Integer categoryId;

    private String name;

    private String subtitle;

    private String mainImage;

    private BigDecimal price;

    private Integer status;
}
