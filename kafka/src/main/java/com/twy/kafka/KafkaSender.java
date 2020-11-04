package com.twy.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author gongpeng
 * @date 2020/11/4 13:54
 */
@Component
@Slf4j
@AllArgsConstructor
public class KafkaSender {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(String topic, String taskId, String jsonStr) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, taskId, jsonStr);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("生产者发送失败，{}", throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                log.info("生产者发送成功，{}", stringObjectSendResult.toString());
            }
        });
    }
}
