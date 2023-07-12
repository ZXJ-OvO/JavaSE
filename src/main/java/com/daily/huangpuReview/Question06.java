package com.daily.huangpuReview;

import java.util.Scanner;

/**
 * 给你一个int范围内的非负整数 x ，计算并返回x的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不要用Java已经提供的API
 * 比如：输入：x = 4	输出：2
 * 比如：输入：x = 8	输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * x² = 8
 * x * x = 8
 */
public class Question06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        System.out.println(sqrt(nextInt));

    }

    public static int sqrt(Integer num) {
        int count = 0;
        while (count * count < num) {
            count++;
        }
        if (count * count > num) {
            return count - 1;
        }
        return count;
    }
}
