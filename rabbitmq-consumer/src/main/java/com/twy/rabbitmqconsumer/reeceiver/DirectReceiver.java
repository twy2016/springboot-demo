package com.twy.rabbitmqconsumer.reeceiver;

import com.rabbitmq.client.Channel;
import com.twy.rabbitmqprovider.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author gongpeng
 * @date 2020/10/27 19:19
 */
@Component
@RabbitListener(queues = "directQueue")
@Slf4j
public class DirectReceiver {

    @RabbitHandler
    public void process(Map map, Message message, Channel channel) throws IOException {
        log.info("第一个消费者收到消息：{}", map.toString());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        log.info("消息已确认");
    }

    @RabbitHandler
    public void process(User user, Message message, Channel channel) throws IOException {
        log.info("第一个消费者收到消息：{}", user.toString());
        if (message.getMessageProperties().getHeaders().get("error") == null) {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info("消息已确认");
        } else {
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            log.info("消息拒绝");
        }
    }
}
