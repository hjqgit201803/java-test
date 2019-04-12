package com.hjq.web.demo.controller;

import com.hjq.web.demo.service.GoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/3/19 13:13
 **/
@RestController
@RequestMapping("/goods")
public class GoodInfoController {


    @Autowired
    private GoodInfoService goodInfoService;







}
