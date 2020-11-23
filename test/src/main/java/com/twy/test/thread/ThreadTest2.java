package com.twy.test.thread;

/**
 * @author gongpeng
 * @date 2020-07-28 15:56
 * @description https://juejin.im/post/6844904100094541837 原子性问题
 */
public class ThreadTest2 {

    private static int number = 0;

    public static void main(String[] args) throws InterruptedException {
        Object flag = new Object();
        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
//                number++;
                synchronized (flag) {
                    number++;
                }
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        Thread t2 = new Thread(runnable);
        t2.start();

        t1.join();
        t2.join();
        System.out.println("number=" + number);
    }
}
