package com.twy.springbootfilter.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author gongpeng
 * @date 2020/8/12 10:57
 */
@Slf4j
//@WebFilter(urlPatterns = "/test/*",filterName = "myFilter")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("MyFilter过滤器开始执行");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("MyFilter过滤器结束执行");
    }

    @Override
    public void destroy() {
        log.info("MyFilter过滤器销毁");
    }
}
