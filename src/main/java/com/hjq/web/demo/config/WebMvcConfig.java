package com.hjq.web.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/10 14:52
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     * 拦截器注册
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        System.out.println("hello  this  is  my  interceptors");
    }


    /**
     * 跨域配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        System.out.println("hello this is my cors setting");
    }
}
