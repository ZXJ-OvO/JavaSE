package com.daily.day02;

import java.util.Scanner;

import static java.lang.Math.min;

/**
 * 题目4: 键盘录入三个整数, 求三个整数最小值
 */
public class Question04 {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("依次回车输入三个整数，系统将自动返回最小值：");
        System.out.println("最小值：" + (int) (min(min(sc.nextDouble(), sc.nextDouble()), sc.nextDouble())));
    }
}
