package com.hjq.web.demo.dao;


import com.hjq.web.demo.pojo.model.OrderDetail;

/**
* @author 18296
* @date 2019-03-19
* @description 
*/
public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}