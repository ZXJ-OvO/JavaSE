package com.zxj.day04;


/**
 * 需求:
 * 现有一个整数数组{100,50,90,60,80,70}。
 * 请编写程序，计算去掉最大值和最小值后的平均值（不考虑小数部分）
 */
public class Question11 {
    public static void main(String[] args) {
        Integer[] array = {100, 50, 90, 60, 80, 70};
        int min = 0;
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                min = array[i];
            } else {
                if (array[i] < min) {
                    min = array[i];
                }
            }
            if (i == 0) {
                max = array[i];
            } else {
                if (max < array[i]) {
                    max = array[i];
                }
            }
        }
        System.out.println("最小值为:" + min);
        System.out.println("最大值为:" + max);
        int sum = 0;
        for (Integer integer : array) {
            if (integer != min && integer != max) {
                sum += integer;
            }
        }
        System.out.println("去掉最大值和最小值后的平均值为:" + sum / (array.length - 2));
    }
}
