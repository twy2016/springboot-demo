package com.twy.springbootlistener.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author gongpeng
 * @date 2020/8/11 16:33
 */
@Component
@Slf4j
public class MySessionListener implements HttpSessionListener {

    public Integer count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("上线了");
        count++;
        se.getSession().getServletContext().setAttribute("count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("下线了");
        count--;
        se.getSession().getServletContext().setAttribute("count", count);
    }


}
