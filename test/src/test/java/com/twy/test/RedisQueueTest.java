package com.twy.test;

import com.twy.test.service.RedisService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author gongpeng
 * @date 2020/10/19 16:57
 */
@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class RedisQueueTest {

    @Autowired
    private RedisService redisService;

    public static final String ORDER_MESSAGE = "order_message";

    @Test
    public void testRedisBlockingQueue() throws InterruptedException {
        // 订单服务
        orderService("bravo1988", 10086L);

        // 启动消费者，取出消息，逐一发送
        new Thread(this::consumeMsg).start();

        // 10秒后再发一条消息，模拟第二次下单
        TimeUnit.SECONDS.sleep(10);
        orderService("bravo2020", 99999L);

        // 等待一会儿，观察第二条消息
        TimeUnit.SECONDS.sleep(10);
    }

    public void orderService(String username, Long orderId) {
        // 1.操作数据库，插入订单

        // 2.其他操作

        // 3.发送消息
        redisService.pushQueue(ORDER_MESSAGE, new Order(username, orderId));
    }

    public void consumeMsg() {
        for (; ; ) {
            Object order = redisService.popQueue(ORDER_MESSAGE, 5, TimeUnit.SECONDS);
            log.info("每隔5秒循环获取，期间for循环阻塞");
            if (order != null) {
                log.info("order:{}", order.toString());
            }
        }
    }

    @Data
    @AllArgsConstructor
    static class Order {
        private String username;
        private Long resumeId;
    }

}
