package com.imooc.mall.service;

import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.form.CartUpdateForm;
import com.imooc.mall.pojo.Cart;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;

import java.util.List;

/**
 * @ClassName ICartService
 * @Author Administrator
 * @Date 2020/3/12 15:35
 */
public interface ICartService {
    ResponseVo<CartVo> add(Integer uuid,CartAddForm cartAddForm);
    ResponseVo<CartVo> list(Integer uuid);
    ResponseVo<CartVo> update(Integer uuid, Integer productId, CartUpdateForm form);
    ResponseVo<CartVo> delete(Integer uuid, Integer productId);
    ResponseVo<CartVo> selectAll(Integer uuid);
    ResponseVo<CartVo> unSelectAll(Integer uuid);
    ResponseVo<Integer> sum(Integer uuid);
    public List<Cart> listForCart(Integer uuid);
}
