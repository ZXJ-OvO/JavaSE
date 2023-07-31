package com.zxj.day19;


import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Question20 {
    public static void main(String[] args) {
        // 定义一个集合存储100份礼物
        List<String> gifts = new ArrayList<>();

        String[] names = new String[]{"小米手机", "美图手机", "苹果笔记本", "智能电烤箱"};
        Random r = new Random();

        for (int i = 1; i <= 100; i++) {
            gifts.add(names[r.nextInt(names.length)]);
        }
        System.out.println("礼物展示" + gifts);

        Runnable getRunnable = new GetRunnable(gifts);
        new Thread(getRunnable, "小明").start();
        new Thread(getRunnable, "小红").start();
    }
}

class GetRunnable implements Runnable {
    private final List<String> gifts;

    public GetRunnable(List<String> gifts) {
        this.gifts = gifts;
    }

    @SneakyThrows
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int count = 0;
        while (true) {
            synchronized (gifts) {
                if (gifts.size() < 10) {
                    break;
                }

                String giftName = gifts.remove(0);
                System.out.println(name + "给员工发出了：" + giftName);
                count++;

                Thread.sleep(50);
            }
        }
        System.out.println(name + "送出了" + count + "份礼物");
    }
}