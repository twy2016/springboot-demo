package com.twy.springbootfilter.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author gongpeng
 * @date 2020/8/12 15:13
 */
@Slf4j
@WebFilter(urlPatterns = "/hello/*",filterName = "testFilter")
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("TestFilter过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("TestFilter过滤器开始执行");
        if ("sb".equals(servletRequest.getParameter("word"))) {
            servletRequest.setAttribute("word", "**");
        } else {
            servletRequest.setAttribute("word", servletRequest.getParameter("word"));
        }
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("TestFilter过滤器结束执行");
    }

    @Override
    public void destroy() {
        log.info("TestFilter过滤器销毁");
    }
}
