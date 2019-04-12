package com.hjq.web.demo.service.impl;

import com.hjq.web.demo.common.enums.ResultCode;
import com.hjq.web.demo.common.utils.EncryptUtils;
import com.hjq.web.demo.common.utils.RegularUtils;
import com.hjq.web.demo.common.utils.Validation;
import com.hjq.web.demo.constant.CommConsts;
import com.hjq.web.demo.dao.UserInfoMapper;
import com.hjq.web.demo.exception.BaseException;
import com.hjq.web.demo.pojo.dto.RegisterUserDTO;
import com.hjq.web.demo.pojo.dto.UserQueryDTO;
import com.hjq.web.demo.pojo.model.UserInfo;
import com.hjq.web.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/3/19 11:18
 **/
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private UserInfoMapper userInfoMapper;


    /**
     * 用户注册
     *
     * @param userInfo
     * @return
     */
    @Override
    public RegisterUserDTO saveUserInfo(RegisterUserDTO userInfo) {
        Validation.notNull(userInfo.getLoginId(), ResultCode.PARAMS_ERROR);
        Validation.notNull(userInfo.getPhone(), ResultCode.PARAMS_ERROR);
        Validation.notNull(userInfo.getPassword(), ResultCode.PARAMS_ERROR);
        Validation.notNull(userInfo.getConfirmPassword(), ResultCode.PARAMS_ERROR);



        Map<String,String> map = new HashMap<String,String>();


        long nowTime = System.currentTimeMillis();
        //校验
        if (!RegularUtils.isPhone(userInfo.getPhone())){
            throw  new BaseException("请输入11位正确的手机号");
        }

        if (checkRegisterUserPhone(userInfo.getPhone())) {
            throw  new BaseException("该手机号已被使用");
        }

        if (checkRegisterUserLoginId(userInfo.getLoginId())){
            throw new BaseException("该登录名已被使用");
        }

        if (!userInfo.getConfirmPassword().equals(userInfo.getPassword())){
            throw new BaseException("两次输入密码不一致");
        }
        //加密
        try {
            String encryptPassword = EncryptUtils.encryptMD5(userInfo.getPassword(),null);
            userInfo.setPassword(encryptPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        userInfo.setValid(CommConsts.USER_VALID);
        userInfo.setUpdateTime(nowTime);
        userInfoMapper.insert(userInfo);

        System.out.println(userInfo.getId());


        return userInfo;
    }

    /**
     * 手机号校验
     * @param phone
     * @return
     */
    private boolean checkRegisterUserPhone(String phone) {
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setPhone(phone);
        UserInfo userInfo = findUserInfoBySomeParam(userQueryDTO);
        if (userInfo != null && userInfo.getId() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 登录名校验
     * @param loginId
     * @return
     */
    private boolean checkRegisterUserLoginId(String loginId) {
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setLoginId(loginId);
        UserInfo userInfo = findUserInfoBySomeParam(userQueryDTO);
        if (userInfo != null && userInfo.getId() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public UserInfo findUserInfoBySomeParam(UserQueryDTO queryDTO) {
        return userInfoMapper.findUserInfoBySomeParam(queryDTO);
    }

    @Override
    public UserInfo findLoginUserInfo(UserQueryDTO queryDTO) {
        return userInfoMapper.findLoginUserInfo(queryDTO);
    }
}
