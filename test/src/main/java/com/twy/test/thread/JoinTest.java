package com.twy.test.thread;

/**
 * @author gongpeng
 * @date 2020/9/15 15:00
 * @description https://www.cnblogs.com/chiweiming/p/11095682.html
 */
public class JoinTest {
    public static void main(String[] args) {
        new Thread(new Thread(() -> {
            System.out.println("老爸要抽烟,发现没烟了,给了100块让儿子去买中华......");
            Thread son = new Thread(() -> {
                System.out.println("儿子接过钱蹦跶出了门");
                System.out.println("路过游戏厅玩了10秒钟");
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i + "秒");
                    try {
                        Thread.sleep(1000); //此时休眠可能会让其他线程进行,出错率增加,通过join方法解决
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("赶紧去买烟");
                System.out.println("回家把烟给老爸");
            });
            son.start();
            try {
                son.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("老爸接过烟,把零钱给了儿子");
            System.out.println("儿子很开心,出门去了游戏厅");
        })).start();
    }
}
