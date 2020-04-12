package com.imooc.mall.service.impl;

import com.imooc.mall.consts.MallConst;
import com.imooc.mall.dao.CategoryMapper;
import com.imooc.mall.pojo.Category;
import com.imooc.mall.service.ICategoryService;
import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName CategoryServiceImpl
 * @Author Administrator
 * @Date 2020/3/11 15:41
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 耗时：http请求最耗时。http（请求微信api）>磁盘(硬盘)>java程序（存在内存中，最快）
     * mysql(内网+磁盘)
     * @return
     */
    @Override
    public ResponseVo<List<CategoryVo>> selectAll() {
        List<Category> categories = categoryMapper.selectAll();
        //查出parentId=0的数据。
//        for (Category category : categories) {
//            if (category.getParentId() == MallConst.ROOT_PARENT_ID){
//                    CategoryVo vo = new CategoryVo();
//                BeanUtils.copyProperties(category,vo);
//                categoryVoList.add(vo);
//            }
//        }
        //lamda+stream
        List<CategoryVo> categoryVoList = categories.stream()
                //w即为category对象，这句话的意思只要parentId=0的对象。
                .filter(w -> w.getParentId().equals(MallConst.ROOT_PARENT_ID))
                //转换对象。
                .map(w -> category2CategoryVo(w))
                //对一级目录进行排序
                .sorted(Comparator.comparing(CategoryVo::getSortOrder).reversed())
                //返回list
                .collect(Collectors.toList());

        //查询子目录。
        findSubCategory(categoryVoList,categories);
        return ResponseVo.success(categoryVoList);
    }

    @Override
    public void findCategoryId(Integer id, Set<Integer> resultSet) {
        List<Category> categories = categoryMapper.selectAll();
        findCategoryId(id,resultSet,categories);
    }
    private void findCategoryId(Integer id, Set<Integer> resultSet,List<Category> categories) {
        for (Category category : categories) {
            if (category.getParentId().equals(id)){
                resultSet.add(category.getId());
                    findCategoryId(category.getId(),resultSet,categories);
            }
        }
    }
    private void findSubCategory(List<CategoryVo> categoryVoList, List<Category> categories){
        for (CategoryVo vo : categoryVoList) {
            List<CategoryVo> voList = new ArrayList<>();
            for (Category category : categories) {
                //如果查到内容。设置subCategory，继续往下查。
                if (vo.getId().equals(category.getParentId())){
                    CategoryVo subCategory = category2CategoryVo(category);
                    voList.add(subCategory);
                }
                //进行排序,倒叙排序。
                voList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
                //设置子目录。
                vo.setSubCategories(voList);
                //将子类目传入，以及数据源传入。
                findSubCategory(voList,categories);
            }
        }
    }
    private CategoryVo category2CategoryVo(Category category){
        CategoryVo vo = new CategoryVo();
        BeanUtils.copyProperties(category,vo);
        return vo;
    }
}
