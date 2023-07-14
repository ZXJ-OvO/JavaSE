package com.daily.huangpuTest;

import java.util.Random;
import java.util.Scanner;


/**
 * 给你一个整数表示红包的总额，和另一个整数表示红包的个数
 * 表示我们要把总金额，随机分成N个红包。
 * 要求1：每个红包的金额都是随机的
 * 要求2：每个人至少1分钱
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入红包的金额");
        int moneyTotal = scanner.nextInt();
        int centTotal = moneyTotal * 100;

        System.out.println("请输入红包分配的人数");
        int person = scanner.nextInt();

        Random random = new Random();
        for (int i = 1; i <= person; i++) {
            if (i == person) {
                System.out.println("最后一个人分配到的红包金额是：" + centTotal / 100.0);
                break;
            }
            // person == 10 则同时代表了10个分，当前是第三个人即i == 3时，就还有10-3=7个人至少要拿一分钱
            // 因此此时最大可分配的分数的数量就是 总分数 - (剩余人数占有的最少分数)  剩余人数占有的最少分数=总人数的分数-当前已分配的人数分数
            int bound = centTotal - (person - i);
            int money = random.nextInt(bound) + 1;
            System.out.println("第" + i + "个人分配到的红包是：" + money / 100.0);
            centTotal -= money;
        }
    }
}
