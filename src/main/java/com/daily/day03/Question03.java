package com.daily.day03;

/**
 * 题目3:编写程序，计算1+3+...+99的值，
 */
public class Question03 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 100; i += 2) {
            sum += i;
        }
        System.out.println("1+3+...+99的值为：" + sum);
    }
}
