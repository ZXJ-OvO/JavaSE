package com.daily.day05;

/**
 * 8.写一个方法，对数组中的任意两个元素，交换位置
 */
public class Question08 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        swap(arr, 0, 4);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index2] ^ arr[index1];
        arr[index1] = arr[index1] ^ arr[index2];
    }
}
