package com.hjq.web.demo.exception;

import com.hjq.web.demo.common.result.JSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 全局异常处理
 * @Author hjq
 * @Date 2019/4/11 14:00
 **/
@RestControllerAdvice
public class GlobalException {

    private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);


    @ExceptionHandler(BaseException.class)
    public JSONResult baseException(HttpServletRequest request, BaseException e){
        loggerDeal(request);
        return new JSONResult(e.getErrorInfo().getCode(),e.getErrorInfo().getMessage());
    }



    @ExceptionHandler(NullPointerException.class)
    public JSONResult nullPointerException(HttpServletRequest request, NullPointerException e){
        return new JSONResult(e.getMessage());
    }


    /**
     * log  deal
     * @param request
     */
    private void loggerDeal(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String requestParams = request.getQueryString();
        logger.error("exception request url is:{} and the queryString  is :{}",uri,requestParams);
    }




}
