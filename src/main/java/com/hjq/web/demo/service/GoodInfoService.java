package com.hjq.web.demo.service;

import com.github.pagehelper.Page;
import com.hjq.web.demo.pojo.dto.GoodQueryDTO;
import com.hjq.web.demo.pojo.model.GoodInfo;

import java.util.List;

/**
 * @Description :
 * @Author hjq
 * @Date 2019/3/19 11:15
 **/
public interface GoodInfoService {


    /**
     * 分页查询商品
     * @param queryDTO
     * @return
     */
    List<GoodInfo> listGoodsOfPage(GoodQueryDTO queryDTO, Page page);


    /**
     * 商品详情
     * @param id
     * @return
     */
    GoodInfo getGoodById(int id);
}
