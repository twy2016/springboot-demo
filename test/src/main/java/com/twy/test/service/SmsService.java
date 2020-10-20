package com.twy.test.service;

import com.twy.test.event.OrderSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 短信服务，监听OrderSuccessEvent
 */
@Service
@Slf4j
public class SmsService implements ApplicationListener<OrderSuccessEvent> {

    @Override
    public void onApplicationEvent(OrderSuccessEvent event) {
        this.sendSms();
    }

    /**
     * 发送短信
     */
    public void sendSms() {
        System.out.println("发送短信开始" + LocalDateTime.now());
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送短信...");
        System.out.println("发送短信结束" + LocalDateTime.now());
    }
}
