package com.daily.day03;

/**
 * 题目5: 求1-100之间所以的偶数和
 */
public class Question04 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 100; i += 2) {
            sum += i;
        }
        System.out.println("1-100之间所以的偶数和为: " + sum);
    }
}
