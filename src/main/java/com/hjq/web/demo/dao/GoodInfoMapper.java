package com.hjq.web.demo.dao;


import com.hjq.web.demo.pojo.dto.GoodQueryDTO;
import com.hjq.web.demo.pojo.model.GoodInfo;

import java.util.List;

/**
* @author 18296
* @date 2019-03-19
* @description 
*/
public interface GoodInfoMapper {

    /**
     * 商品列表查询
     * @param queryDTO
     * @return
     */
    List<GoodInfo> listGoodsOfPage(GoodQueryDTO queryDTO);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    int insert(GoodInfo record);

    int insertSelective(GoodInfo record);

    GoodInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodInfo record);

    int updateByPrimaryKey(GoodInfo record);
}