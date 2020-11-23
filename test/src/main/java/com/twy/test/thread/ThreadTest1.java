package com.twy.test.thread;

/**
 * @author gongpeng
 * @date 2020-07-28 15:43
 * @description https://juejin.im/post/6844904100094541837  变量共享可见性
 */
public class ThreadTest1 {

    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                /**
                 * 新增输出 println方法里有锁，会共享变量
                 * public void println(boolean x) {
                 *     synchronized (this) {
                 *         print(x);
                 *         newLine();
                 *     }
                 * }
                 */
                System.out.println(flag);
                if (!flag) {
                    System.out.println("进入if");
                    break;
                }
            }
        });
        t1.start();

        Thread.sleep(1000);

        Thread t2 = new Thread(() -> {
            flag = false;
            System.out.println("修改了");
        });
        t2.start();
    }
}
