package com.twy.test.thread;

/**
 * @author gongpeng
 * @date 2020/8/7 14:33
 * @description wait()和notify()方法的使用
 */
public class ThreadTest3 {

    private static Object object = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (object) {
                for (int i = 1; i <= 100; i += 2) {
                    object.notify();
                    System.out.println("奇数："+i);
                    try {
                        if (i < 100) {
                            object.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (object) {
                for (int i = 2; i <= 100; i += 2) {
                    object.notify();
                    System.out.println("偶数："+i);
                    if (i == 100) {
                        break;
                    }
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
