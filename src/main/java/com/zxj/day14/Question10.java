package com.zxj.day14;

import java.util.Arrays;

/**
 * 查找排序算法
 */
public class Question10 {
    public static void main(String[] args) {
        Integer[] array = {5, 2, 3, 1};


        System.out.println(Arrays.toString(bubbleSort(array)));
        System.out.println(Arrays.toString(selectSort(array)));

        Integer[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(arr, 4));
    }

    /**
     * 冒泡排序
     */
    public static Integer[] bubbleSort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
            }
        }

        return array;
    }

    /**
     * 选择排序
     */
    public static Integer[] selectSort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    array[i] = array[i] ^ array[j];
                    array[j] = array[i] ^ array[j];
                    array[i] = array[i] ^ array[j];
                }
            }
        }

        return array;
    }

    /**
     * 二分查找
     */
    public static Integer binarySearch(Integer[] array, Integer target) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (target > array[middle]) {
                left = middle + 1;
            } else if (target < array[middle]) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
