package com.daily.day03;

import java.util.Arrays;
import java.util.Random;

/**
 * 题目2：程序自动生成一个1-100之间的随机数字，使用程序实现猜出这个数字是多少？
 */
public class Question02 {
    public static void main(String[] args) {
        Random random = new Random();
        int index = random.nextInt(100) + 1;
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int num = arr[index];
        int i = Arrays.binarySearch(arr, 1, 100, num);
        System.out.println("随机数为：" + num + "，猜出的数字的索引为：" + i);
    }
}
