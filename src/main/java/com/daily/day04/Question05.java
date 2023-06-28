package com.daily.day04;

import java.util.Arrays;
import java.util.Random;

/**
 * 题目5:
 * 从随机生成10个1-100之间的整数存入数组。（包含1，包含100）。
 * 将生成的10个数，按照奇数在左边，偶数在右边进行打印输出元素。
 * 输出示例： 1,57,25,47,7,2,84,36,58,24
 */
public class Question05 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] odd = new int[10];
        int[] even = new int[10];
        int countOdd = 0;
        int countEven = 0;
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
        System.out.println("随机生成的数组为：");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                countEven++;
                even[countEven - 1] = arr[i];
            }
            if (arr[i] % 2 != 0) {
                countOdd++;
                odd[countOdd - 1] = arr[i];
            }
        }
        System.out.println("奇数数组为：");
        System.out.println(Arrays.toString(odd));
        System.out.println("偶数数组为：");
        System.out.println(Arrays.toString(even));
        for (int i = 0; i < countEven; i++) {
            arr[i] = even[i];
        }
        for (int i = 0; i < countOdd; i++) {
            arr[i] = odd[i];
        }
        System.out.println("奇偶数交换后的数组为：");
        System.out.println(Arrays.toString(arr));

    }
}
