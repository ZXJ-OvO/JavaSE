package com.daily.day06;

/**
 * 题目二: 打印1~1000以内能同时被2和3整除的数，两个一行、三个一行打印。例如：
 * 6 12
 * 18 24 30
 * 36 42
 * 48 54 60
 * 66 72
 * 78 84 90
 */
public class Question02 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            if (i % 6 == 0) {
                System.out.print(i + " ");
                if (i % 10 == 2) {
                    System.out.println();
                }
                if (i % 10 == 0) {
                    System.out.println();
                }
            }

        }
    }
}