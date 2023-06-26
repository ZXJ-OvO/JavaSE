package com.daily.day02;

import java.util.Scanner;

/**
 * 题目1：键盘录入三位同学的年龄，用程序实现获取这三个同学的最大年龄。
 */
public class Question01 {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("依次回车输入三位同学的年龄，系统将自动返回最年长者：");
        System.out.println("最年长者：" + Math.max(Math.max(sc.nextInt(), sc.nextInt()), sc.nextInt()) + "岁");
    }
}
