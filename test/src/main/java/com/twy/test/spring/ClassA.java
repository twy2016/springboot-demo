package com.twy.test.spring;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author gongpeng
 * @date 2020/8/10 9:53
 */
@Component
//@AllArgsConstructor
@Slf4j
public class ClassA {

    public Logger logger = LoggerFactory.getLogger(ClassA.class);

    @Autowired
    private ClassB classB;

    public static void main(String[] args) {
        String name = new String("123");
        log.info("测试={}", name);
    }
}
