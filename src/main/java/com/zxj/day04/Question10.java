package com.zxj.day04;

/**
 * 需求:
 * 现有一个整数数组{100,50,90,60,80,70}。请编写代码，计算数组中的所有元素的最大值并打印。
 */
public class Question10 {
    public static void main(String[] args) {
        int[] arr = {100, 50, 90, 60, 80, 70};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (i == 0) {
                max = arr[i];
            } else {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
        }
        System.out.println("最大值为:" + max);
    }
}

