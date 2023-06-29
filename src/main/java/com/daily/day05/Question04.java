package com.daily.day05;

import java.util.Arrays;

/**
 * 4.写一个方法，求int数组中元素的最小值
 */
public class Question04 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(getMin(arr));
    }

    public static int getMin(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }
}
