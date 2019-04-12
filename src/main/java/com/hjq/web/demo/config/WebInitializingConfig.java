package com.hjq.web.demo.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/2 13:14
 **/
@Configuration
public class WebInitializingConfig implements InitializingBean , DisposableBean {


    @Override
    public void destroy() throws Exception {
        System.out.println("spring destroy method");
    }

    /**
     * bean 容器初始化之后执行
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {


        System.out.println("execute  afterProperties   method");

    }


}
