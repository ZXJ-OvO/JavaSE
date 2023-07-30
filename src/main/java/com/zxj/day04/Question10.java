package com.zxj.day04;

import java.util.Arrays;

/**
 * 需求:
 * 现有一个整数数组{100,50,90,60,80,70}。请编写代码，计算数组中的所有元素的最大值并打印。
 */
public class Question10 {
    public static void main(String[] args) {
        int[] arr = {100, 50, 90, 60, 80, 70};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("最大值为:" + arr[arr.length - 1]);
    }
}

