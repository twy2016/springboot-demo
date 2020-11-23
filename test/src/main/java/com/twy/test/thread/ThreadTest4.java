package com.twy.test.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gongpeng
 * @date 2020/8/7 15:13
 * @description wait()和notify()方法的使用
 */
public class ThreadTest4 {

    private static List<String> list = new ArrayList<>();

    public void add() {
        list.add("test");
    }

    public static void main(String[] args) throws InterruptedException {
        Object flag = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (flag) {
                System.out.println("t1启动");
                for (int i = 0; i < 10; i++) {
                    new ThreadTest4().add();
                    System.out.println("t1添加元素");
                    if (list.size() == 5) {
                        try {
                            System.out.println("t1阻塞等待唤醒");
                            flag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (flag) {
                System.out.println("t2启动");
                if (list.size() == 5) {
                    flag.notify();
                    System.out.println("唤醒t1");
                }
            }
        });
        t1.start();
        Thread.sleep(1000L);
        t2.start();
    }
}
