package com.daily.huangpuReview;

/**
 * 给你一个非空整数数组nums，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 * 比如：
 * 输入：nums = [2,2,1]	输出：1
 * 输入：nums = [4,1,2,1,2]	输出：4
 * 输入：nums = [1]		输出：1
 */
public class Question02 {
    public static void main(String[] args) {
        int[] nums = {41, 23, 23, 41};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    if (j == (nums.length - 1)) {
                        System.out.println(nums[i]);
                    }
                }
            }

        }
    }
}
