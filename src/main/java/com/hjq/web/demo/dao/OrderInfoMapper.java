package com.hjq.web.demo.dao;


import com.hjq.web.demo.pojo.model.OrderInfo;

/**
* @author 18296
* @date 2019-03-19
* @description 
*/
public interface OrderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}