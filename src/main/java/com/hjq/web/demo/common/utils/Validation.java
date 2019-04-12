package com.hjq.web.demo.common.utils;

import com.hjq.web.demo.common.enums.ResultCode;
import com.hjq.web.demo.exception.BaseException;

/**
 * @Description:参数校验类，并抛出异常
 * @Author hjq
 * @Date 2019/4/11 11:17
 **/
public class Validation {


    /**
     * 校验指定参数
     *
     * @param obj
     * @param resultCode
     */
    public static void notNull(Object obj, ResultCode resultCode) {
        notNull(obj, resultCode, null);
    }

    /**
     * 校验指定参数，可指定异常信息
     *
     * @param obj
     * @param resultCode
     * @param msg
     */
    public static void notNull(Object obj, ResultCode resultCode, String msg) {
        if (StringUtils.isEmpty(obj)) {
            if (!StringUtils.isEmpty(msg)){
                resultCode.setMessage(msg);
            }
            throw new BaseException(resultCode);
        }
    }


}
