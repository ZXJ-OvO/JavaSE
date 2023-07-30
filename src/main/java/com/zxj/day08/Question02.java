package com.zxj.day08;

import java.util.Random;

/**
 * * 定义数组 int arr [] = new int[5]
 * * 需求如下
 *   1.  完成对数组的初始化，要求采用键盘录入(也可以使用随机数)的形式，范围为1-100（包含1和100）
 *   2.  将数组中的元素按照如下格式打印:
 *   3.  获取数组的平均值，将结果打印在控制台
 */
public class Question02 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100) + 1;
        }
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        System.out.println("数组的平均值为：" + sum / arr.length);
    }
}
