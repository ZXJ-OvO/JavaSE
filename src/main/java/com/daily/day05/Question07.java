package com.daily.day05;

/**
 * 7.写一个方法，求int数组中指定元素的索引，找到了返回索引，找不到返回-1
 */
public class Question07 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        int index = findIndex(arr, target);
        System.out.println(index);
    }

    public static int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
