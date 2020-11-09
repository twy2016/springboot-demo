package com.twy.test.controller;

import com.twy.test.config.Logger;
import com.twy.test.entity.Item;
import com.twy.test.util.ThreadLocalUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gongpeng
 * @date 2020/10/19 21:32
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public void test() {
        System.out.println(ThreadLocalUtil.get("userName"));
    }

    @GetMapping("/aop")
    @Logger(url = "/aop")
    public Item aop() {
        Item item = new Item();
        item.setAddress("杭州");
        item.setName("唐万言");
        int i = 1/0;
        return item;
    }
}
