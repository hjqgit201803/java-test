package com.hjq.web.demo.service;

import com.hjq.web.demo.pojo.dto.RegisterUserDTO;
import com.hjq.web.demo.pojo.dto.UserQueryDTO;
import com.hjq.web.demo.pojo.model.UserInfo;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/3/19 11:15
 **/
public interface UserInfoService {


    /**
     * 保存用户信息
     * @param userInfo
     * @return
     */
    RegisterUserDTO saveUserInfo(RegisterUserDTO userInfo);

    /**
     * 获取登录用户信息
     * @return
     */
    UserInfo findUserInfoBySomeParam(UserQueryDTO queryDTO);


    /**
     * 获取用户信息
     * @return
     */
    UserInfo findLoginUserInfo(UserQueryDTO queryDTO);






}
