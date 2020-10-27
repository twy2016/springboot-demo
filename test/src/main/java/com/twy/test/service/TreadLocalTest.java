package com.twy.test.service;

import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gongpeng
 * @date 2020/10/27 15:04
 */
@Configuration
public class TreadLocalTest {

    public static void main(String[] args) throws InterruptedException {
        InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set("1111");

        Thread thread = new Thread(() -> {
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread + threadLocal.get());
        });
        thread.start();
        Thread.sleep(500);
        System.out.println("-------------------华丽的分割线-----------------");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Thread(()->{
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread + threadLocal.get());
        }));
//        IntStream.range(0, 10).parallel().forEach(id -> {
//            System.out.println(id + "_~_~_" + threadLocal.get());
//        });
    }
}
