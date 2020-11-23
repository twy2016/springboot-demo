package com.twy.test.thread;

/**
 * @author gongpeng
 * @date 2020/8/7 15:36
 * @description 线程中断方法
 */
public class ThreadTest5 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("线程运行");
            for (int i = 0; i < 1000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("通过this.isInterrupted()检测到中断");
                    System.out.println("第一个interrupted():" + Thread.currentThread().interrupted());
                    System.out.println("第二个interrupted():" + Thread.currentThread().interrupted());
                    break;
                }
                System.out.println(i);
            }
            System.out.println("因为检测到中断，所以跳出循环，线程到这里结束，因为后面没有内容了");
        });
        t1.start();
        Thread.sleep(1L);
        t1.interrupt();
        System.out.println("thread是否被中断：" + t1.isInterrupted());
        System.out.println("thread是否存活：" + t1.isAlive());
    }
}
