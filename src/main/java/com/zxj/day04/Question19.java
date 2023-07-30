package com.zxj.day04;

import java.util.ArrayList;

/**
 * 定义一个数组其中包含多个数字。用自己的方式最终实现，
 * 奇数放在数组的左边，偶数放在数组的右边。（可以创建其他数组，不必须在原数组中改变）
 */
public class Question19 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i : arr) {
            if (i / 2 == 0) even.add(i);
            if (i / 2 != 0) odd.add(i);
        }
        odd.forEach(System.out::println);
        even.forEach(System.out::println);
    }
}
