package com.hjq.web.demo.exception;

import com.hjq.web.demo.common.enums.ResultCode;
import com.hjq.web.demo.common.result.ErrorInfo;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/11 15:18
 **/
public class BaseException extends RuntimeException {

    private ErrorInfo errorInfo;

    public BaseException() {
        super(ResultCode.FAIL.getMessage());
        this.errorInfo = new ErrorInfo(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
    }

    public BaseException(String msg) {
        super(msg);
        this.errorInfo = new ErrorInfo(ResultCode.FAIL.getCode(), msg);
    }

    public BaseException(String code, String msg) {
        super(msg);
        this.errorInfo = new ErrorInfo(code, msg);
    }


    public BaseException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.errorInfo = new ErrorInfo(resultCode.getCode(), resultCode.getMessage());
    }



    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }
}
