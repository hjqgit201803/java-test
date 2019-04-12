package com.hjq.web.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hjq.web.demo.dao.GoodInfoMapper;
import com.hjq.web.demo.pojo.dto.GoodQueryDTO;
import com.hjq.web.demo.pojo.model.GoodInfo;
import com.hjq.web.demo.service.GoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description:商品业务类
 * @Author hjq
 * @Date 2019/3/19 11:18
 **/
@Service("goodInfoService")
public class GoodInfoServiceImpl implements GoodInfoService {

    @Autowired
    private GoodInfoMapper goodInfoMapper;

    /**
     * 商品分页
     * @param queryDTO
     * @param page
     * @return
     */
    @Override
    public List<GoodInfo> listGoodsOfPage(GoodQueryDTO queryDTO, Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return goodInfoMapper.listGoodsOfPage(queryDTO);
    }

    /**
     * 商品详情
     * @param id
     * @return
     */
    @Override
    public GoodInfo getGoodById(int id) {
        return goodInfoMapper.selectByPrimaryKey(id);
    }
}
