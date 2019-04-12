package com.hjq.web.demo.controller;

import com.hjq.web.demo.common.result.JSONResult;
import com.hjq.web.demo.pojo.dto.RegisterUserDTO;
import com.hjq.web.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/11 16:32
 **/
@RestController
@RequestMapping("/exoteric/register")
public class RegisterController {

    @Autowired
    private UserInfoService userInfoService;



    @PostMapping
    public JSONResult  register(@RequestBody RegisterUserDTO registerUserDTO){
        RegisterUserDTO user = userInfoService.saveUserInfo(registerUserDTO);
        return new JSONResult(user);
    }













}
