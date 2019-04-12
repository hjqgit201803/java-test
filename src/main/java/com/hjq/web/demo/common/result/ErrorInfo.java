package com.hjq.web.demo.common.result;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/11 15:22
 **/
public class ErrorInfo {


    private String code;

    private String message;

    public ErrorInfo(){}

    public ErrorInfo(String code,String message){
        this.code=code;
        this.message=message;
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
}
