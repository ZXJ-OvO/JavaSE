package com.daily.day03;

import java.util.Random;

/**
 * 题目2：程序自动生成一个1-100之间的随机数字，使用程序实现猜出这个数字是多少？
 */
public class Question02 {
    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(100) + 1;
        int left = 1;
        int right = 100;
        for (int i = 0; i < 100; i++) {
        }
    }
}
