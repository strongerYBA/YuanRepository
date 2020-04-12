package com.imooc.mall.vo;

import com.imooc.mall.pojo.OrderItem;
import com.imooc.mall.pojo.Shipping;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderVo
 * @Author Administrator
 * @Date 2020/3/16 22:35
 */
@Data
public class OrderVo {
    private Long orderNo;
    private BigDecimal payment;
    private Integer paymentType;
    private Integer postage;
    private Integer status;
    private Date paymentTime;
    private Date sendTime;
    private Date closeTime;
    private Date createTime;
    private Date endTime;
    private List<OrderItemVo> orderItemVoList;
    private Integer shippingId;
    private Shipping shippingVo;
}
