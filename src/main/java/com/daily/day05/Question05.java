package com.daily.day05;

/**
 * 5.写一个方法，求int数组中元素的和
 */
public class Question05 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(sum(arr));
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
