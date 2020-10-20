package com.twy.redislock.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author gongpeng
 * @date 2020/10/20 18:41
 */
@RestController
@RequestMapping("/redisson")
@Slf4j
public class RedissonController {

    private static final String PRODUCT_KEY = "productKey";

    private static final String LOCK_KEY = "redisLock";

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/lock")
    public void lockTest() {
        RLock lock = redissonClient.getLock(LOCK_KEY);
        // 设置5秒过期时间
        lock.lock(5, TimeUnit.SECONDS);
        String lockValue = lock.toString();
        log.info("[{}]成功获取锁，开始执行业务。。。", lockValue);
        RAtomicLong atomicLong = redissonClient.getAtomicLong(PRODUCT_KEY);
        long surplus = atomicLong.get();
        if (surplus < 0) {
            lock.unlock();
            log.info("[{}]库存不足，释放锁", lockValue);
            return;
        }
        log.info("[{}]当前库存[{}]，库存 -1，剩余库存[{}]", lockValue, surplus, atomicLong.decrementAndGet());
        log.info("[{}]操作完成，释放锁", lockValue);
        lock.unlock();
    }
}
