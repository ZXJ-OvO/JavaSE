package com.daily.day05;

import java.util.Arrays;
import java.util.Random;

/**
 * 1.写一个方法，能够随机产生若干个[1,100]范围内的随机数，存储到数组中，并把数组返回
 */
public class Question01 {
    public static void main(String[] args) {
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = new Random().nextInt(100) + 1;
        }
        System.out.println(Arrays.toString(ints));
    }
}
