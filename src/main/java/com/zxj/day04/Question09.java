package com.zxj.day04;

/**
 * 需求:
 * 	现有一个整数数组{100,50,90,60,80,70}。请编写代码，计算数组中的所有元素的最小值并打印。
 */
public class Question09 {
    public static void main(String[] args) {
        Integer[] array = {100, 50, 90, 60, 80, 70};
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                min = array[i];
            } else {
                if (array[i] < min) {
                    min = array[i];
                }
            }
        }
        System.out.println("最小值为:" + min);
    }
}
