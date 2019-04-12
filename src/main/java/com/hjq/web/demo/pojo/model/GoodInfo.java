package com.hjq.web.demo.pojo.model;


import lombok.Data;

/**
 * @author hjq
 * @date 2019-03-19
 * @description 商品信息
 */
@Data
public class GoodInfo {
    //
    private Integer id;

    //商品名称
    private String goodName;

    //图片地址
    private String goodUrl;

    //价格
    private Float price;

    //店面主键
    private Integer shopId;

    //店面名称
    private String shopName;

    //商品亮点
    private String lightspot;

    //库存数量
    private Integer storeNum;

    //已售数量
    private Integer hasSellNum;

    //有效状态（-1无效1有效）
    private Short valid;

    //最后更新用户
    private Integer updateUserId;

    //最后更新时间
    private Long updateTime;



}