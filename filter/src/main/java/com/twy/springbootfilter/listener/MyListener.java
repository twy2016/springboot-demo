package com.twy.springbootfilter.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author gongpeng
 * @date 2020/8/12 14:11
 */
@Slf4j
//@WebListener
public class MyListener implements HttpSessionListener {

    private int count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count++;
        log.info("用户上线了");
        se.getSession().getServletContext().setAttribute("count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
        log.info("用户下线了");
        se.getSession().getServletContext().setAttribute("count", count);
    }
}
