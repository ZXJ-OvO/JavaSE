package com.daily.day05;

import java.util.Arrays;

/**
 * 3.写一个方法，求int数组中元素的最大值
 */
public class Question03 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}
