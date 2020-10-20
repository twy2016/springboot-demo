package com.twy.test.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author gongpeng
 * @date 2020/10/19 16:55
 */
@Component
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void pushQueue(String queue, Object obj) {
        try {
            redisTemplate.opsForList().leftPush(queue, objectMapper.writeValueAsString(obj));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object popQueue(String queue, long timeout, TimeUnit timeUnit) {
        return redisTemplate.opsForList().rightPop(queue, timeout, timeUnit);
    }
}
