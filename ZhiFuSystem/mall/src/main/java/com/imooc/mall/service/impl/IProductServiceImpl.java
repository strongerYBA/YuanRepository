package com.imooc.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.mall.dao.ProductMapper;
import com.imooc.mall.enums.ProductStatusEnum;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.pojo.Product;
import com.imooc.mall.service.ICategoryService;
import com.imooc.mall.service.IProductService;
import com.imooc.mall.vo.ProductDetailVo;
import com.imooc.mall.vo.ProductVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName IProductServiceImpl
 * @Author Administrator
 * @Date 2020/3/11 22:58
 */
@Slf4j
@Service
public class IProductServiceImpl implements IProductService {
    @Resource
    private ICategoryService categoryService;
    @Resource
    private ProductMapper productMapper;
    @Override
    public ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categorySet = new HashSet<>();
        if (categoryId != null) {
            categoryService.findCategoryId(categoryId, categorySet);
            //将自身的categoryId加进来。
            categorySet.add(categoryId);
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Product> products = productMapper.selectByCategoryIdSet(categorySet);
        List<ProductVo> productVos = products.stream()
                .map(e -> {
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(e, productVo);
                    return productVo;
                }).collect(Collectors.toList());

        PageInfo pageInfo  = new PageInfo(products);
        pageInfo.setList(productVos);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<ProductDetailVo> detail(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        //判断商品是否下架或已删除。
        if (product.getStatus().equals(ProductStatusEnum.OFF_SALE.getCode())
        || product.getStatus().equals(ProductStatusEnum.DELETE.getCode())){
          return ResponseVo.error(ResponseEnum.PRODUCT_DELETE_OR_OFF_SALE);
        }
        ProductDetailVo vo = new ProductDetailVo();
        BeanUtils.copyProperties(product,vo);
        //敏感数据处理。
        vo.setStock(product.getStock() > 100?100:product.getStock());
        return ResponseVo.success(vo);
    }

}
