package com.imooc.mall.service;

        import com.github.pagehelper.PageInfo;
        import com.imooc.mall.form.ShippingForm;
        import com.imooc.mall.vo.ResponseVo;

        import java.util.Map;

/**
 * @ClassName IShippingService
 * @Author Administrator
 * @Date 2020/3/14 22:08
 */
public interface IShippingService {
    ResponseVo<Map<String,Integer>> add(Integer uid, ShippingForm shippingForm);
    ResponseVo delete(Integer uid, Integer shippingId);
    ResponseVo update(Integer uid, Integer shippingId,ShippingForm shippingForm);
    ResponseVo<PageInfo> list(Integer uid,Integer pageNum,Integer pageSize);
}
