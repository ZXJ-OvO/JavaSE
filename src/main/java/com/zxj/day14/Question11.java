package com.zxj.day14;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 `nums`，和一个目标值 `target`。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 `target`，返回 `[-1, -1]`。
 * **注意：必须确保程序的时间复杂度是o(log2n)，否则不给分数**
 * **具体功能点的要求如下：**
 * 数组 nums = [5,7,7,8,8,10], target = 8
 * 得到结果是：[3,4]
 * 数组：nums = [5,7,7,8,8,10], target = 6
 * 得到结果是：[-1,-1]
 * 数组：nums = [], target = 0
 * 得到结果是：[-1,-1]
 * 请设计一个方法完成以上需求，并编写测试代码完成上述测试。
 */
public class Question11 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 8, 10, 5, 7, 7, 8, 8, 8, 8, 10, 5, 7, 7, 8, 8, 8, 8, 10, 5, 7, 7, 8, 8, 8, 8, 10, 5, 7, 7, 8, 8, 8, 8, 10, 5, 7, 7, 8, 8, 8, 8, 10, 5, 7, 7, 8, 8, 8, 8, 10, 5, 7, 7, 8, 8, 8, 8, 10, 5, 7, 7, 8, 8, 8, 8, 10, 5, 7, 7, 8, 8, 8, 8, 10, 5, 7, 7, 8, 8, 8, 8, 10, 5, 7, 7, 8, 8, 8, 8, 10, 5, 7, 7, 8, 8, 8, 8, 10, 5, 7, 7, 8, 8, 8, 8, 10};
        Arrays.sort(nums);
        int lastIndexOf = ArrayUtil.lastIndexOf(nums, 8);
        int firstIndexOf = ArrayUtil.indexOf(nums, 8);
        System.out.println("[" + firstIndexOf + "," + lastIndexOf + "]");


    }
}

