package com.daily.day03;

/**
 * 题目1：统计1~任意给定值之间出现了几次数字9
 */
public class Question01 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; ++i) {
            if (i % 10 == 9) {
                count++;
            }
            if (i / 10 == 9) {
                count++;
            }
        }
        System.out.println("1~100之间出现了" + count + "次数字9");
    }
}