package com.zxj.day19;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有100份礼品，小红，小明两人同时发送，当剩下的礼品小于10份的时候则不再送出，
 * 利用多线程模拟该过程并将线程的名称打印出来。
 * 并最后在控制台分别打印小红，小明各自送出多少分礼物。
 */
public class Question19 {
    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        Gift gift = new Gift(lock);
        FutureTask<Integer> task1 = new FutureTask<>(gift);
        FutureTask<Integer> task2 = new FutureTask<>(gift);

        Thread thread1 = new Thread(task1, "小明");
        Thread thread2 = new Thread(task2, "小红");

        thread1.start();
        thread2.start();

        Integer i = task1.get();
        Integer j = task2.get();

        System.out.println("小明送出了" + i + "份礼物");
        System.out.println("小红送出了" + j + "份礼物");

    }
}

class Gift implements Callable<Integer> {
    private static Integer giftNum = 100;
    public Integer num1 = 0;
    public Integer num2 = 0;
    public static Lock lock = new ReentrantLock();

    public Gift(Lock lock) {
        this.lock = lock;
    }

    @Override
    public Integer call() throws Exception {
        while (giftNum > 10) {
            lock.lock();
            giftNum--;
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "送出了一份礼物,还剩" + giftNum + "份礼物");
            if (Thread.currentThread().getName().equals("小明")) {
                num1++;
            } else {
                num2++;
            }
            // 为了让另一个线程也能进入while循环，让出CPU
            //Thread.sleep(100);

        }
        return Thread.currentThread().getName().equals("小明") ? num1 : num2;
    }
}
