package com.hjq.web.demo.common.result;

import com.hjq.web.demo.common.enums.ResultCode;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/11 14:44
 **/
public class JSONResult {

    private String code;

    private String message;

    private Object data;

    public JSONResult() {

    }

    public JSONResult(ResultCode resultCode) {
        this(resultCode.getCode(), null, resultCode.getMessage());
    }

    public JSONResult(String code) {
        this(code, null, null);
    }

    /**
     * 当参数无code
     * 默认是成功
     *
     * @param data
     */
    public JSONResult(Object data) {
        this(ResultCode.SUCCESS.getCode(), data, null);
    }

    public JSONResult(String code, Object data) {
        this(code, data, null);
    }


    public JSONResult(String code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.message = msg;
    }

    public static JSONResult success() {
        return new JSONResult(ResultCode.SUCCESS.getCode());
    }

    public static JSONResult fail() {
        return new JSONResult(ResultCode.FAIL.getCode());
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
