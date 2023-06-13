package com.zxj.day03;

import java.util.Scanner;

/**
 * 需求：键盘录入考试成绩，根据成绩所在的区间，程序打印出不同的奖励机制
 * 90 ~ 94  游乐园
 * 95 ~ 100 自行车
 * 80 ~ 89  玩具
 * 0  ~ 80  挨打
 */
public class Question02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入考试成绩：");
            int score = sc.nextInt();

            if (score >= 90 && score <= 94) {
                System.out.println("奖励游乐园");
                break;
            } else if (score >= 95 && score <= 100) {
                System.out.println("奖励自行车");
                break;
            } else if (score >= 80 && score <= 89) {
                System.out.println("奖励玩具");
                break;
            } else if (0 < score && score < 80) {
                System.out.println("挨打");
                break;
            } else {
                System.out.println("输入有误，请重新输入");
            }
        }
    }
}
