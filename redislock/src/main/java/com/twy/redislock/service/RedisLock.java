package com.twy.redislock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author gongpeng
 * @date 2020/10/20 15:20
 */
@Component
public class RedisLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public Boolean addLock(String key, String value) {
        //必须要给锁加一个过期时间：这样即使中间系统异常了，等过期时间到了，也可以自动释放锁，防止出现死锁现象
        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent(key, value, 5, TimeUnit.SECONDS);
        if (lock == null) {
            return false;
        }
        return lock;
    }

    public Boolean unLock(String key, String value) {
        // 执行 lua 脚本        
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        // 指定 lua 脚本        
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("redis/unLock.lua")));
        // 指定返回类型        
        redisScript.setResultType(Long.class);
        //  参数一：redisScript，参数二：key列表，参数三：arg（可多个）        
        Long result = stringRedisTemplate.execute(redisScript, Collections.singletonList(key), value);
        return result != null && result > 0;
    }
}
