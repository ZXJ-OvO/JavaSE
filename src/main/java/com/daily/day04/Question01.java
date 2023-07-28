package com.daily.day04;

import java.util.Arrays;
import java.util.Random;

/**
 * 题目一: 小柠檬去参加青年歌手大奖赛,有10个评委打分,去掉一个最高分一个最低分求平均分。
 */
public class Question01 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
        arr[0] = 0;
        arr[arr.length - 1] = 0;
        System.out.println(Arrays.toString(arr));

        double avg = 0;
        for (int j : arr) {
            avg += j;
        }
        System.out.println(avg / arr.length);
    }
}
