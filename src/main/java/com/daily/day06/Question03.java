package com.daily.day06;

import java.util.Arrays;
import java.util.Random;

/**
 * 题目三:随机生成5个随机数,随机数的范围在1-100之间(包含1,包含100)
 * 需求:
 * 求5个数的最大值.
 * 求5个数的最小值.
 * 求5个数的和.
 * 求5个数的平均数.
 */
public class Question03 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[5];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }

        int i = arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
        Arrays.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("max = " + arr[arr.length - 1]);
        System.out.println("min = " + arr[0]);
        System.out.println("sum = " + i);
        System.out.println("avg = " + (double) i / arr.length);
    }
}
