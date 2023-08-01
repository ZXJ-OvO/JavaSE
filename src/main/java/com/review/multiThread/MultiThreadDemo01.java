package com.review.multiThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 礼物分发问题
 * 两个人同时分发100份礼品，演示分发过程，礼品数不足10件时停止分发，分别统计分发总件数
 */
public class MultiThreadDemo01 {
    public static void main(String[] args) {
        // 准备100份礼品
        ArrayList<String> gifts = new ArrayList<>();
        String[] items = {"手机", "冰箱", "空调", "三金"};
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(4);
            gifts.add(items[index]);
        }
        Collections.shuffle(gifts);

        // 创建两个线程分发礼品
        DistributeThread thread1 = new DistributeThread("徐磊", gifts);
        DistributeThread thread2 = new DistributeThread("朱磊", gifts);

        thread1.start();
        thread2.start();

    }
}

class DistributeThread extends Thread {
    private final ArrayList<String> gifts;
    private int count;

    public DistributeThread(String name, ArrayList<String> gifts) {
        super(name);
        this.gifts = gifts;
    }

    @Override
    public void run() {
        while (gifts.size() >= 10) {
            synchronized (this) {
                String name = Thread.currentThread().getName();
                String gift = gifts.remove(0);
                count++;
                System.out.println(name + " 分发出一个 " + gift + " 礼物剩余份数 " + gifts.size());
            }
        }

        String name = Thread.currentThread().getName();
        System.out.println(name + "分发礼品总计数：" + count);
    }
}
