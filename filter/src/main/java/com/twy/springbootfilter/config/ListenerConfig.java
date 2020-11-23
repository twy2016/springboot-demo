package com.twy.springbootfilter.config;

import com.twy.springbootfilter.listener.MyListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.EventListener;

/**
 * @author gongpeng
 * @date 2020/8/12 14:14
 */
//@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean ServletListenerRegistrationBean(){
        ServletListenerRegistrationBean<EventListener> registrationBean = new ServletListenerRegistrationBean<>();
        registrationBean.setListener(new MyListener());
        return registrationBean;
    }
}
