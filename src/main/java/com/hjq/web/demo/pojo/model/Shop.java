package com.hjq.web.demo.pojo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 18296
 * @date 2019-03-19
 * @description
 */
@Getter
@Setter
public class Shop {
    //
    private Integer id;

    //店铺名称
    private String shopName;

    //创建用户ID
    private Integer createUserId;

    //最后更新用户
    private Integer updateUserId;

    //最后更新时间
    private Long updateTime;
}