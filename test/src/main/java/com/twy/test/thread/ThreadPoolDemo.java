package com.twy.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author gongpeng
 * @date 2020/8/18 14:24
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10,20,5, TimeUnit.SECONDS,new LinkedBlockingQueue<>(200));
        CountDownLatch latch = new CountDownLatch(10);
        poolExecutor.execute(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                latch.countDown();
            }
        });
        latch.await();
        poolExecutor.shutdown();
    }
}
