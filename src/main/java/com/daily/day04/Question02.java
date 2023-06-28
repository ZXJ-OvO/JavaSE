package com.daily.day04;

import java.util.Arrays;

/**
 * 题目二: 班上有5名同学, 身高从高到低排列(单位cm) 分别为: 165, 164, 163, 162, 161
 * 现在要求身高从低到高排列, 请用代码实现
 */
public class Question02 {
    public static void main(String[] args) {
        Integer[] arr = {165, 164, 163, 162, 161};
        Arrays.sort(arr, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(arr));
    }
}
