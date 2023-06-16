package com.zxj.day08;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组 nums，编写一个方法将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
 */
public class Question13 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) if (arr[i] != 0) list.add(arr[i]);
        int[] newArr = new int[arr.length];
        for (int i = 0; i < list.size(); i++) newArr[i] = list.get(i);

        System.out.print("[");
        for (int i = 0; i < newArr.length; i++) {
            if (i == newArr.length - 1) System.out.print(newArr[i]);
            else System.out.print(newArr[i] + ",");
        }
        System.out.println("]");
    }
}
