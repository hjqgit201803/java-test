package com.hjq.web.demo.common.utils;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/8 13:00
 **/
public class StringUtils {


    /**
     * 判空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        return obj == null || "".equals(obj);
    }

}
