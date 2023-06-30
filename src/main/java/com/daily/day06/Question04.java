package com.daily.day06;

import java.util.Arrays;

/**
 * 题目四: 定义一个方法实现获取一个int数组：键盘录入数组的长度和随机数的范围（范围区间要大于数组长度），在数组中存储指定范围的随机数，并且随机数不能重复
 */
public class Question04 {
    public static void main(String[] args) {
        getArray(10, 1, 20);
    }

    public static void getArray(int length, int start, int end) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * (end - start + 1) + start);
            arr[i] = random;
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] == arr[j]) {
                        i--;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
