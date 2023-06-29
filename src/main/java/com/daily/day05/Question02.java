package com.daily.day05;

/**
 * 2.写一个方法，打印数组中的元素, 格式是：[元素1,元素2,元素3]
 */
public class Question02 {
    public static void main(String[] args) {
        printArray(new int[]{1, 2, 3, 4, 5});
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print(arr[i]);
            } else {
                System.out.print("," + arr[i]);
            }
        }
        System.out.println("]");
    }
}
