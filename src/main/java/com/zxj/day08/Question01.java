package com.zxj.day08;

import java.util.Scanner;

/**
 * * 键盘录入六个 1-10（包含1和10）之间的数字存入数组中
 * * 然后计算出去掉最大值与最小值的平均数
 */
public class Question01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个数字");
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
        int min = arr[0];
        for (int j : arr) {
            if (max < j) {
                max = j;
            }
            if (min > j) {
                min = j;
            }
            sum += j;
        }
        System.out.println("最大值为：" + max);
        System.out.println("最小值为：" + min);
        System.out.println("平均值为：" + (sum - max - min) / (arr.length - 2));
    }
}