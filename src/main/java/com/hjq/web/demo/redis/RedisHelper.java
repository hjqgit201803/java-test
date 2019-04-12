package com.hjq.web.demo.redis;

import com.alibaba.fastjson.JSON;
import com.hjq.web.demo.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;


/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/8 16:25
 **/
public class RedisHelper {


    private static final Logger logger = LoggerFactory.getLogger(RedisHelper.class);


    @Autowired
    JedisPool jedisPool;


    /**
     * set  String value with expire
     *
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public String setStringValue(String key, String value, int expire) {
        String res = "";
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            res = jedis.setex(key, expire, value);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("redis operation unsuccessful,key:{},value:{}",key,value);
        } finally {
            judgeAndClose(jedis);
        }
        return res;
    }

    /**
     * set String value
     *
     * @param key
     * @param value
     * @return
     */
    public String setStringValue(String key, String value) {
        String res = "";
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            res = jedis.set(key, value);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("redis setStringValue unsuccessful,key:{},value:{}",key,value);
        } finally {
            judgeAndClose(jedis);
        }
        return res;
    }


    /**
     * get string
     *
     * @param key
     * @return
     */
    public String getVlaue(String key) {
        String res = "";
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            res = jedis.get(key);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("redis getVlaue unsuccessful,key:{}",key);
        } finally {
            judgeAndClose(jedis);
        }
        return res;
    }

    /**
     * get  object
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getObjectValue(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String res = jedis.get(key);
            if (!StringUtils.isEmpty(res)) {
                return JSON.parseObject(res, clazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("redis getObjectValue  unsuccessful,key:{}",key);
        } finally {
            judgeAndClose(jedis);
        }
        return null;
    }

    /**
     * get  array
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> getArrayValue(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String res = jedis.get(key);
            if (!StringUtils.isEmpty(res)) {
                return JSON.parseArray(res,clazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("redis getArrayValue unsuccessful,key:{}",key);
        } finally {
            judgeAndClose(jedis);
        }
        return null;
    }


    /**
     * 归还
     *
     * @param jedis
     */
    private void judgeAndClose(Jedis jedis) {
        if (null != jedis) {
            jedis.close();
        }
    }


}
