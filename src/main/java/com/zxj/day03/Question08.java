package com.zxj.day03;

import java.util.Random;

/**
 * 随机生成一个1-100之间的数据，提示用户猜测，猜大提示过大，猜小提示过小，直到猜中结束游戏。
 */
public class Question08 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int random = rnd.nextInt(100) + 1;
        while (true) {
            System.out.println("请输入一个1-100之间的整数：");
            int input = new java.util.Scanner(System.in).nextInt();
            if (input > random) {
                System.out.println("过大");
            } else if (input < random) {
                System.out.println("过小");
            } else {
                System.out.println("猜中");
                break;
            }
        }
    }
}
