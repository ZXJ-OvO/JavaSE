package com.zxj.day04;

import java.util.Arrays;

/**
 * 数组元素求最大值 15 9000 10000 20000 9500 -5
 */
public class Question04 {
    public static void main(String[] args) {
        int[] array = {15, 9000, 10000, 20000, 9500, -5};
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }
        Arrays.sort(array);
        System.out.println("最大值为：" + max);
    }
}
