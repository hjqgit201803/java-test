package com.hjq.web.demo.pojo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author 18296
 * @date 2019-03-19
 * @description
 */
@Getter
@Setter
public class OrderDetail {
    //
    private Integer id;

    //订单ID
    private Integer orderId;

    //商品ID
    private Integer goodId;

    //购买商品数量
    private Integer buyGoodNum;

    //是否折扣（1是，2否）
    private Short hasDiscount;

    //实际付款
    private BigDecimal actualPay;

    //创建时间
    private Long createTime;

    //最后更新用户
    private Integer updateUserId;

    //最后更新时间
    private Long updateTime;
}