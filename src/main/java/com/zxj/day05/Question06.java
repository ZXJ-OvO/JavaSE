package com.zxj.day05;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个方法可以接收整型数组，和要查询的元素值；
 * 最终要返回元素在该数组中的索引，如果数组中不存在该元素则返回 -1。
 */
public class Question06 {
    public static void main(String[] args) {
        int[] array = {1, 9, 8, 9, 6, 4,};
        findIndex(array, 9);
    }

    public static void findIndex(int[] array, int value) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                list.add(i);
            }
        }
        for (Integer integer : list) {
            System.out.print(integer + "\t");
        }
    }
}
