package com.hjq.web.demo.pojo.dto;

import com.hjq.web.demo.pojo.model.UserInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/11 15:46
 **/
@Getter
@Setter
public class RegisterUserDTO extends UserInfo {

    private String confirmPassword;


}
