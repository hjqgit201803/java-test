package com.hjq.web.demo.filter;

import com.hjq.web.demo.constant.CommConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/2 13:18
 **/
public class LoginSessionFilter implements Filter {


    private static final Logger logger = LoggerFactory.getLogger(LoginSessionFilter.class);


    private String excludePath;

    private String logoutPath;



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request  =  (HttpServletRequest) servletRequest;


        String uri  =request.getRequestURI();


        String url = request.getRequestURL().toString();


        String serverPath = request.getServletPath();


        System.out.println("uri:"+uri+"====url:"+url);
        System.out.println(serverPath+"========");



        filterChain.doFilter(servletRequest,servletResponse);

    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludePath = filterConfig.getInitParameter(CommConsts.EXCLUDE_PATH);
        logoutPath = filterConfig.getInitParameter(CommConsts.LOGOUT_PATH);

    }

    @Override
    public void destroy() {



    }
}
