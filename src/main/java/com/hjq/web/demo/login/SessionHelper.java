package com.hjq.web.demo.login;


import com.hjq.web.demo.pojo.dto.LoginUser;

import java.util.UUID;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/10 17:14
 **/
public class SessionHelper {


    private static final String CONNECT_SESSION = "_&";


    /**
     * make session
     *
     * @param loginUser
     * @return
     */
    public static String makeSesisonId(LoginUser loginUser) {
        return String.valueOf(loginUser.getUserId()).concat(CONNECT_SESSION).concat(generateUUID());
    }


    /**
     * get  user  key
     *
     * @param sessionId
     * @return
     */
    public static String userKey(String sessionId) {
        if (sessionId.indexOf(CONNECT_SESSION) != -1) {
            return sessionId.substring(0, sessionId.indexOf(CONNECT_SESSION));
        }
        return sessionId;
    }


    /**
     * get user version
     *
     * @param sessionId
     * @return
     */
    public static String userVersion(String sessionId) {
        if (sessionId.indexOf(CONNECT_SESSION) != -1) {
            return sessionId.substring(sessionId.indexOf(CONNECT_SESSION)+CONNECT_SESSION.length());
        }
        return sessionId;
    }


    /**
     * uuid generate
     *
     * @return
     */
    private static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
