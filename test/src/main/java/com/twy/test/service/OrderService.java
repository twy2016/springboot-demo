package com.twy.test.service;

/**
 * @author gongpeng
 * @date 2020/10/19 11:04
 */

import com.twy.test.event.OrderSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 订单服务
 */
@Service
@Slf4j
public class OrderService {

    @Autowired
    private ApplicationContext applicationContext;

    public void order() {
        // 下单成功
        log.info("下单成功, 订单号:{}", 1111);
        // 发布通知（传入了当前对象）
        new Thread(()->{
            applicationContext.publishEvent(new OrderSuccessEvent(this));
        }).start();
        System.out.println("main线程结束...");
        // 等SmsService结束
        try {
            Thread.sleep(1000L * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test(){
        System.out.println("orderService其他方法");
    }
}
