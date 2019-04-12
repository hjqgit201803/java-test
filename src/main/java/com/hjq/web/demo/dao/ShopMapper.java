package com.hjq.web.demo.dao;


import com.hjq.web.demo.pojo.model.Shop;

/**
* @author 18296
* @date 2019-03-19
* @description 
*/
public interface ShopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}