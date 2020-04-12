package com.imooc.mall.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName CategoryVo
 * @Author Administrator
 * @Date 2020/3/11 15:35
 */
@Data
public class CategoryVo {
    private Integer id;
    private Integer parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private List<CategoryVo> subCategories;
}
