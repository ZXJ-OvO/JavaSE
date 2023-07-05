package com.daily.day04;

import java.util.Arrays;
import java.util.Random;

/**
 * 题目三:生成10个随机数添加到数组当中，要求保证数据是唯一，不重复的。
 * 注意点：
 * 1，存储元素的时候只能用数组，不能用集合
 * 2，随机数的范围：11 ~ 73，包含11，也包含73
 */
public class Question03 {
    public static void main(String[] args) {
        int[] ints = new int[50];
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(63) + 11;
            for (int j = 0; j < i; j++) {
                if (ints[i] == ints[j]) {
                    i--;
                }
            }

        }
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
