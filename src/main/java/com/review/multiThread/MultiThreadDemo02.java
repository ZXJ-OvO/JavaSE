package com.review.multiThread;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 奖池抽奖问题
 * 每次抽的过程中，不打印，抽完时一次性打印(随机)
 * 在此次抽奖过程中，抽奖箱1总共产生了6个奖项，分别为：10,20,100,500,2,300最高奖项为300元，总计额为932元
 * 在此次抽奖过程中，抽奖箱2总共产生了6个奖项，分别为：5,50,200,800,80,700最高奖项为800元，总计额为1835元
 */
public class MultiThreadDemo02 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);
        Collections.shuffle(list);

        LuckyDrawThread thread1 = new LuckyDrawThread("朱磊", list);
        LuckyDrawThread thread2 = new LuckyDrawThread("徐磊", list);

        thread1.start();
        thread2.start();

    }
}

class LuckyDrawThread extends Thread {

    private ArrayList<Integer> list;
    private ArrayList<Integer> box = new ArrayList<>();

    public LuckyDrawThread(String name, ArrayList<Integer> list) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (list.isEmpty()) {
                    break;
                }
                String name = Thread.currentThread().getName();
                Integer money = list.remove(0);
                box.add(money);
                System.out.println(name + "产生了一个大奖：" + money + " 元");
            }
        }
        String name = Thread.currentThread().getName();
        int size = box.size();
        Collections.sort(box);
        int max = box.get(box.size() - 1);
        int sum = box.stream().mapToInt(Integer::intValue).sum();
        System.out.println(name + "产生了" + size + "个奖项，分别为：" + box + "最高奖项为：" + max + "总价值：" + sum + " 元");
    }
}