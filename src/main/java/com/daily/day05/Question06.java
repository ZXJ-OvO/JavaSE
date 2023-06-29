package com.daily.day05;

/**
 * 6.写一个方法，求int数组中元素的平均值
 */
public class Question06 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("平均值为：" + average(arr));
    }

    public static int average(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum / arr.length;
    }
}
