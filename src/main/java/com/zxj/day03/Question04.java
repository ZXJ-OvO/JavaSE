package com.zxj.day03;

import java.util.Scanner;

/**
 * 需求：求1-5之间的数据和，并把求和结果在控制台输出。
 */
public class Question04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入左边界：");
        int a = in.nextInt();
        System.out.println("请输入右边界：");
        int b = in.nextInt();
        System.out.println("求和结果为：" + sum(a, b));
    }

    public static int sum(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += i;
        }
        return sum;
    }
}
