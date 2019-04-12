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
public class OrderInfo {
    //
    private Integer id;

    //订单号
    private Long orderNo;

    //下单时间
    private Long orderTime;

    //应付金额
    private BigDecimal oughtPay;

    //实付金额
    private BigDecimal actualPay;

    //用户ID
    private Integer userId;

    //买家手机号（下单时的手机号码）
    private String userPhone;

    //是否使用优惠卷（1是，2否）
    private Short useCoupons;

    //优惠卷信息
    private String couponsContent;

    //付款方式（1支付宝2银联3其他）
    private Short payType;

    //状态（1已下单待支付，2已支付，3待发货，4已发货，5待签收，6已签收，7确认收货，8已取消，9已退货，10已退款）
    private Integer orderStatus;

    //收货地址
    private String shippingAddr;

    //创建时间
    private Long createTime;

    //最后更新用户
    private Integer updateUserId;

    //最后更新时间
    private Long updateTime;
}