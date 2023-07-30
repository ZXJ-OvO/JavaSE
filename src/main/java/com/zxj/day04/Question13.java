package com.zxj.day04;

import java.util.Arrays;

/**
 * 请创建一个长度为6的整数数组，并为数组中的元素赋值。遍历数组，打印所有元素，元素之间用空格隔开。比如：
 * 数组为：{1,2,3,4,5}
 * 打印结果：1 2 3 4 5
 */
public class Question13 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        String string = Arrays.toString(arr);
        String replace = string.replace(",", " ");
        System.out.println(replace);
        String substring = replace.substring(1, replace.length() - 1);
        System.out.println(substring);

    }
}

