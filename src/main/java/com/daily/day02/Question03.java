package com.daily.day02;

import java.util.Scanner;

/**
 * 题目3: 键盘录入一个整数,判断这个数是奇数还是偶数
 */
public class Question03 {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("键盘录入一个整数，系统将判断这个数是奇数还是偶数：");
        System.out.println(sc.nextInt() % 2 == 0 ? "偶数" : "奇数");
    }
}
