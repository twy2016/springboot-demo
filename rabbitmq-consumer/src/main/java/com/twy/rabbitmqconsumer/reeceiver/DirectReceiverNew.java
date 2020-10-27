package com.twy.rabbitmqconsumer.reeceiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author gongpeng
 * @date 2020/10/27 19:19
 */
@Component
@RabbitListener(queues = "directQueue")
@Slf4j
public class DirectReceiverNew {

    @RabbitHandler
    public void process(Map message) {
        log.info("第二个消费者收到消息：{}", message.toString());
    }
}
