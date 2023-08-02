package com.daily.finalExam.Demo04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * **需求**
 * 某个游乐园举办了一场游戏活动，参与的游客有100名，游客的编号依次是1, 2，3, 4，..到100。
 * 现在游戏活动中有一个抓娃娃机环节，要求共计发出200次抓娃娃机会。
 * 其中小娃娃在[1 - 10]元之间，总占比为60%，中娃娃[11-50]元，总占比为30%，大娃娃[51-100]元，总占比为10%。
 * 1、系统模拟上述要求产生200次抓娃娃机会。
 * 2、模拟100名游客通过娃娃机进行抓娃娃，需要输出哪个游客抓到哪个娃娃的过程，活动结束时需要提示活动结束。
 * 3、活动结束后，请按照每个游客抓到娃娃的总金额进行降序排序展示，
 * **例如：3号游客抓娃娃总计6个，总价是：293元、1号游客抓娃娃10个总计250元，....**
 */
public class Test04 {
    public static void main(String[] args) {
        // 预先生成200个娃娃的价值量
        ArrayList<Integer> dollWealth = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 120; i++) {
            int wealth = random.nextInt(10) + 1;
            dollWealth.add(wealth);
        }
        for (int i = 0; i < 60; i++) {
            int wealth = random.nextInt(40) + 11;
            dollWealth.add(wealth);
        }
        for (int i = 0; i < 20; i++) {
            int wealth = random.nextInt(50) + 51;
            dollWealth.add(wealth);
        }

        Collections.shuffle(dollWealth);

        // 100个游客抓娃娃
        for (int i = 1; i <= 100; i++) {
            CatchDolls catchDolls = new CatchDolls("游客" + i, dollWealth);
            catchDolls.start();
        }


        // TODO: 2023/8/2 排序

    }
}

class CatchDolls extends Thread {
    private final ArrayList<Integer> dollWealth;
    private int wealthTotal = 0;
    private int dollTotal = 0;
    public static HashMap hashMap = new HashMap();

    public CatchDolls(String name, ArrayList<Integer> dollWealth) {
        super(name);
        this.dollWealth = dollWealth;
    }

    @Override
    public void run() {
        while (!dollWealth.isEmpty()) {
            synchronized (this) {
                String name = Thread.currentThread().getName();
                Integer money = dollWealth.get(0);
                dollWealth.remove(0);
                wealthTotal += money;
                dollTotal++;
                System.out.println(name + "抓到了" + money + "元的娃娃");

                // 用HashMap存储每个人抓到的娃娃的总价值
                hashMap.put(name, wealthTotal);

            }
            break;
        }
        System.out.println(Thread.currentThread().getName() + "抓到了" + dollTotal + "个娃娃，总价值：" + wealthTotal + "元");


        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 对hashMap按照值进行排序
    }
}
