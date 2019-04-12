package com.hjq.web.demo.config;

import com.hjq.web.demo.constant.CommConsts;
import com.hjq.web.demo.filter.LoginSessionFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description:过滤器配置
 * @Author hjq
 * @Date 2019/4/2 13:14
 **/
@Configuration
public class FilterRegisterConfig {

    @Value("${filter.excludePath}")
    private String excludePath;

    @Value("${filter.logoutPath}")
    private String logoutPath;


    @Bean
    public FilterRegistrationBean filterRegistration1() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.addInitParameter(CommConsts.EXCLUDE_PATH,excludePath);
        filterRegistrationBean.addInitParameter(CommConsts.LOGOUT_PATH,logoutPath);
        filterRegistrationBean.setName("loginSessionFilter");
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setFilter(new LoginSessionFilter());
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;

    }


}
