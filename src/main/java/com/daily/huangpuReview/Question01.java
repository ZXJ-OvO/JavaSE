package com.daily.huangpuReview;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class Question01 {
    public static void main(String[] args) {
        int[] nums = {10, 6, 0, -1, 1, 0, 8, 21};
        int target = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    int[] ints = {i, j};
                    System.out.println(Arrays.toString(ints));
                }
            }
        }
    }
}
