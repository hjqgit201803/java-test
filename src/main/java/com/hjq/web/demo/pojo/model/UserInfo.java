package com.hjq.web.demo.pojo.model;

import lombok.Getter;
import lombok.Setter;

;

/**
 * @author 18296
 * @date 2019-03-19
 * @description
 */
@Getter
@Setter
public class UserInfo {
    //主键
    private Integer id;

    //登录ID
    private String loginId;

    //用户名称
    private String userName;

    //密码
    private String password;

    //手机号
    private String phone;

    //性别（1男；2女）
    private Short sex;

    //地址
    private String address;

    //最后登录时间
    private Long lastLoginTime;

    //最后更新人
    private Integer updateUserId;

    //最后更新时间
    private Long updateTime;

    //有效状态（-1无效1有效）
    private Short valid;


}