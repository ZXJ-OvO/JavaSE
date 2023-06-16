package com.zxj.day08;

import java.util.Random;

/**
 * 创建一个长度为6的int型数组，要求数组元素值都是1-30之间，且是随机赋值，要求各元素互相不重复。
 * (15分:创建数组并赋值给8分,去重给7分)
 */
public class Question12 {
    public static void main(String[] args) {
        int[] arr = new int[6];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(30) + 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
