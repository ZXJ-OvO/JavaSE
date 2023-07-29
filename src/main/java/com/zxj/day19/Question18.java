package com.zxj.day19;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2.每次抽的过程中，不打印，抽完时一次性打印(随机)
 * 在此次抽奖过程中，抽奖箱1总共产生了6个奖项，分别为：10,20,100,500,2,300最高奖项为300元，总计额为932元
 * 在此次抽奖过程中，抽奖箱2总共产生了6个奖项，分别为：5,50,200,800,80,700最高奖项为800元，总计额为1835元
 * <p>
 * 3.每次抽的过程中，不打印，抽完时一次性打印(随机)
 * 在此次抽奖过程中，抽奖箱1总共产生了6个奖项，分别为：10,20,100,500,2,300最高奖项为300元，总计额为932元
 * 在此次抽奖过程中，抽奖箱2总共产生了6个奖项，分别为：5,50,200,800,80,700最高奖项为800元，总计额为1835元
 * 在此次抽奖过程中,抽奖箱2中产生了最大奖项,该奖项金额为800元
 * <p>
 * 以上打印效果只是数据模拟,实际代码运行的效果会有差异
 */
public class Question18 {
    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        LuckyDraw luckyDraw = new LuckyDraw(lock);
        FutureTask<ArrayList<Integer>> task1 = new FutureTask<>(luckyDraw);
        FutureTask<ArrayList<Integer>> task2 = new FutureTask<>(luckyDraw);

        Thread thread1 = new Thread(task1, "boxOne");
        Thread thread2 = new Thread(task2, "boxTwo");

        thread1.start();
        thread2.start();
        ArrayList<Integer> boxOne = task1.get();
        ArrayList<Integer> boxTwo = task2.get();

        Collections.sort(boxOne);
        Collections.sort(boxTwo);

        System.out.println("在此次抽奖过程中，抽奖箱1总共产生了" + boxOne.size() + "个奖项，分别为：" + boxOne + "最高奖项为" + boxOne.get(boxOne.size() - 1) + "元，总计额为" + boxOne.stream().mapToInt(Integer::intValue).sum() + "元");
        System.out.println("在此次抽" +
                "奖过程中，抽奖箱2总共产生了" + boxTwo.size() + "个奖项，分别为：" + boxTwo + "最高奖项为" + boxTwo.get(boxTwo.size() - 1) + "元，总计额为" + boxTwo.stream().mapToInt(Integer::intValue).sum() + "元");

        if (boxOne.get(boxOne.size() - 1) > boxTwo.get(boxTwo.size() - 1)) {
            System.out.println("在此次抽奖过程中,抽奖箱1中产生了最大奖项,该奖项金额为" + boxOne.get(boxOne.size() - 1) + "元");
        } else {
            System.out.println("在此次抽奖过程中,抽奖箱2中产生了最大奖项,该奖项金额为" + boxTwo.get(boxTwo.size() - 1) + "元");
        }


    }
}

class LuckyDraw implements Callable<ArrayList<Integer>> {
    private static final Integer[] numArr = {5, 10, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700};
    private static ArrayList<Integer> bonus = new ArrayList<>();
    public ArrayList<Integer> boxOne = new ArrayList<>();
    public ArrayList<Integer> boxTwo = new ArrayList<>();
    public static Lock lock;

    public LuckyDraw(Lock lock) {
        LuckyDraw.lock = lock;
    }

    static {
        CollUtil.addAll(bonus, numArr);
    }

    @Override
    public ArrayList<Integer> call() throws InterruptedException {

        while (!bonus.isEmpty()) {
            lock.lock();
            Integer remove = bonus.remove(0);
            lock.unlock();
            String name = Thread.currentThread().getName();
            if (name.equals("boxOne")) {
                boxOne.add(remove);
            } else {
                boxTwo.add(remove);
            }
            System.out.println("😎️😎️😎️😎️🥰🥰🥰🥰🥳🥳🥳🥳");

        }

        return Thread.currentThread().getName().equals("boxOne") ? boxOne : boxTwo;
    }
}