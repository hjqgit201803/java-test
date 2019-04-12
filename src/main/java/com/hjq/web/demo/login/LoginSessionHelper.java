package com.hjq.web.demo.login;

import com.alibaba.fastjson.JSON;
import com.hjq.web.demo.common.utils.CookieUtils;
import com.hjq.web.demo.constant.CacheConsts;
import com.hjq.web.demo.constant.SessionConsts;
import com.hjq.web.demo.pojo.dto.LoginUser;
import com.hjq.web.demo.redis.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/10 17:11
 **/
public class LoginSessionHelper {


    //存活时间（单位/秒）
    private static final int USER_LOGIN_EXPIRE_TIME = 60 * 60 * 2;


    @Autowired
    private RedisHelper redisHelper;


    /**
     * login
     *
     * @param sessionId
     * @param loginUser
     */
    public void login(String sessionId, LoginUser loginUser, HttpServletRequest request, HttpServletResponse response) {

        if (null == loginUser || loginUser.getUserId() <= 0) {
            throw new IllegalArgumentException("login user info  can't be empty!");
        }
        String userKey = SessionHelper.userKey(sessionId);
        String redisKey = redisKey(userKey);
        redisHelper.setStringValue(redisKey, JSON.toJSONString(loginUser), USER_LOGIN_EXPIRE_TIME);

        //set in  cookie
        CookieUtils.set(request,response,SessionConsts.LOGIN_SESSION,sessionId,USER_LOGIN_EXPIRE_TIME,true,false);

    }

    /**
     * logout
     *
     * @param request
     * @param response
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.remove(request, response, SessionConsts.LOGIN_SESSION);
    }

    /**
     * check login
     * @param request
     * @return
     */
    public LoginUser checkLogin(HttpServletRequest request) {

        String cookieValue = CookieUtils.getValue(request,SessionConsts.LOGIN_SESSION,true);

        String userKey = SessionHelper.userKey(cookieValue);

        String redisKey  = redisKey(userKey);

        LoginUser loginUser = redisHelper.getObjectValue(redisKey, LoginUser.class);

        if (loginUser!=null){
            //将时间重置
            redisHelper.setStringValue(redisKey,JSON.toJSONString(loginUser),USER_LOGIN_EXPIRE_TIME);
            return loginUser;
        }


        return null;
    }


    /**
     * redis  key
     *
     * @param userKey
     * @return
     */
    private String redisKey(String userKey) {
        return CacheConsts.USER_KEY_PREFIX.concat(userKey);
    }

}
