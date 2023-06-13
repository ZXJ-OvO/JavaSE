package com.zxj.day04;

/**
 * 请创建一个长度为6的整数数组，并为数组中的元素赋值。遍历数组，打印所有元素，元素之间用空格隔开。比如：
 * 数组为：{1,2,3,4,5}
 * 打印结果：1 2 3 4 5
 */
public class Question12 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            // 判断是否为最后一个元素
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }

        }
    }
}
