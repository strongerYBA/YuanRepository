package com.imooc.mall.service;

import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

/**
 * @ClassName ICategoryService
 * @Author Administrator
 * @Date 2020/3/11 15:40
 */
public interface ICategoryService {
    ResponseVo<List<CategoryVo>> selectAll();

    /**
     * 获取子类及其子子类的id。
     * @param id
     * @param resultSet
     */
    void findCategoryId(Integer id, Set<Integer> resultSet);
}
