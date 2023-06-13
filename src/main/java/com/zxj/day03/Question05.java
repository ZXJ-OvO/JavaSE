package com.zxj.day03;

import java.util.Scanner;

/**
 * 需求：求1-10之间的奇数和，并把求和结果在控制台输出。
 */
public class Question05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入左边界：");
        int a = in.nextInt();
        System.out.println("请输入右边界：");
        int b = in.nextInt();
        System.out.println("区间内的奇数和结果为：" + sum(a, b));
    }

    public static int sum(int a, int b) {
        // 求a到b中的奇数和
        int sum = 0;
        for (int i = a; i <= b; i+=2) {
                sum += i;
        }
        return sum;
    }
}
