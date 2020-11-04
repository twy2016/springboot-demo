package com.twy.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author gongpeng
 * @date 2020/11/4 15:49
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "test")
    public void receive(ConsumerRecord<?, ?> record){
        log.info("消费得到的消息---key: " + record.key());
        log.info("消费得到的消息---value: " + record.value().toString());
    }

}
