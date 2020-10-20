package com.twy.test.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author gongpeng
 * @date 2020/10/19 11:04
 */
public class OrderSuccessEvent extends ApplicationEvent {

    public OrderSuccessEvent(Object source) {
        super(source);
    }
}
