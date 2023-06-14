package com.zxj.day05;

import java.util.Scanner;

/**
 * 求 1-n的和。
 */
public class Question01 {
    public static void main(String[] args) {
        System.out.print("请输入一个整数以求和：");
        System.out.println(sum(new Scanner(System.in).nextInt()));
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
}
