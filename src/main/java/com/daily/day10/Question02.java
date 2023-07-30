package com.daily.day10;

import java.util.ArrayList;

/**
 * 定义一个方式实现查找索引：键盘录入一个数，在指定的数组中获取该数在数组中的索引，如果没有则返回-1。有，有几个索引返回几个索引
 */
public class Question02 {
    public static void main(String[] args) {
        int[] array = {10, 2, 30, 4, 50, 30};
        ArrayList<Integer> indexList = selectIndex(array, 30);
        if (!indexList.isEmpty())
            System.out.println("30在array数组中的索引有" + indexList.size() + "个" + "分别是：" + indexList);
        else
            System.out.println("-1");

    }

    public static ArrayList<Integer> selectIndex(int[] array, int num) {

        ArrayList<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                indexList.add(i);
            }
        }

        return indexList;
    }
}
