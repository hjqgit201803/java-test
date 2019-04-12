package com.hjq.web.demo.dao;

import com.hjq.web.demo.pojo.dto.UserQueryDTO;
import com.hjq.web.demo.pojo.model.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
* @author hjq
* @date 2019-03-19
* @description 
*/
public interface UserInfoMapper {


    /**
     * 用户查询（登录）
     * @param queryDTO
     * @return
     */
    UserInfo findLoginUserInfo(UserQueryDTO queryDTO);


    /**
     * 用户查询（其他参数）
     * @param queryDTO
     * @return
     */
    UserInfo findUserInfoBySomeParam( UserQueryDTO queryDTO);


    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存
     * @param record
     * @return
     */
    int insert(UserInfo record);


    /**
     * 查询
     * @param id
     * @return
     */
    UserInfo selectByPrimaryKey(Integer id);



}