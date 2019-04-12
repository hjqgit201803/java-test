package com.hjq.web.demo.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/8 12:37
 **/
public class CookieUtils {


    //default  enc
    private static final String DEFAULT_ENCODE = "utf-8";

    /**
     * set  cookie
     *
     * @param request
     * @param response
     * @param key
     * @param value
     */
    public static void set(HttpServletRequest request, HttpServletResponse response, String key, String value) {
        set(request, response, key, value, 0);
    }


    /**
     * set  cookie
     *
     * @param request
     * @param response
     * @param key
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletRequest request, HttpServletResponse response, String key, String value, int maxAge) {
        set(request, response, key, value, maxAge, false);
    }

    /**
     * set  cookie
     *
     * @param request
     * @param response
     * @param key
     * @param value
     * @param maxAge
     * @param isHttpOnly
     */
    public static void set(HttpServletRequest request, HttpServletResponse response, String key, String value, int maxAge, boolean isHttpOnly) {
        set(request, response, key, value, maxAge, false, isHttpOnly);
    }


    /**
     * set  cookie
     *
     * @param request
     * @param response
     * @param key
     * @param value
     * @param maxAge
     * @param encode
     * @param isHttpOnly
     */
    public static void set(HttpServletRequest request, HttpServletResponse response, String key, String value, int maxAge, boolean encode, boolean isHttpOnly) {
        Cookie cookie = new Cookie(key, value);

        String requestUri = request.getRequestURI();

        //有效时间
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        //编码
        if (encode) {
            try {
                URLEncoder.encode(cookie.getValue(), DEFAULT_ENCODE);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        //域名
        String domain;
        if (!StringUtils.isEmpty((domain = getDomianName(requestUri)))) {
            cookie.setDomain(domain);
        }
        cookie.setHttpOnly(isHttpOnly);
        response.addCookie(cookie);
    }


    /**
     * get value
     *
     * @param request
     * @param key
     * @return
     */
    public static String getValue(HttpServletRequest request, String key) {
        return getValue(request, key, false);
    }


    /**
     * get value
     *
     * @param request
     * @param key
     * @param isDecode
     * @return
     */
    public static String getValue(HttpServletRequest request, String key, boolean isDecode) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (key.equals(cookie.getName())) {
                if (isDecode) {
                    try {
                        return URLDecoder.decode(cookie.getValue(), DEFAULT_ENCODE);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                } else {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }


    /**
     * get cookie
     *
     * @param request
     * @param key
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (key.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

    /**
     * remove  cookie
     *
     * @param request
     * @param response
     * @param key
     */
    public static void remove(HttpServletRequest request, HttpServletResponse response, String key) {
        if (!StringUtils.isEmpty(getCookie(request, key))) {
            set(request, response, key, "", 0);
        }
    }


    /**
     * 获取域名
     *
     * @param requestUrl
     * @return
     */
    public static String getDomianName(String requestUrl) {
        String domain = "";


        return domain;
    }


}
