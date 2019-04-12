package com.hjq.web.demo.pojo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description:商品查询传输对象
 * @Author hjq
 * @Date 2019/3/19 11:34
 **/
@Getter
@Setter
public class GoodQueryDTO {

//    商品名称
    private String goodName;
//    商品ID
    private Integer goodId;

//    分类ID
    private Integer categoryId;


}
