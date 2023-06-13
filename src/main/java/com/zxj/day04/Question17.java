package com.zxj.day04;

/**
 * 有一个数组，其中有十个元素从小到大依次排列 {12,14,23,45,66,68,70,77,90,91}。
 * 再通过键盘录入一个整数数字。要求：把数字放入数组序列中，生成一个新的数组，
 * 并且数组的元素依旧是从小到大排列的。执行效果如下：
 * 请输入一个整数数字：
 * 50
 * 生成的新数组是：12 14 23 45 50 66 68 70 77 90
 */
public class Question17 {
    public static void main(String[] args) {
        int[] arr = {12, 14, 23, 45, 66, 68, 70, 77, 90, 91};
        int[] newArr = new int[arr.length + 1]; // 新数组
        int num = 50;
        int index = 0; // 记录插入位置
        for (int i = 0; i < arr.length; i++) {
            // 如果当前元素小于插入元素，直接赋值 否则插入元素并记录位置
            if (arr[i] < num) {
                newArr[i] = arr[i];
            } else {
                newArr[i] = num;
                index = i;
                break; // 跳出循环 此时新数组中存在的最大元素为插入值 且记录了插入位置
            }
        }
        // 将后面的元素赋值给新数组
        for (int i = index; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
}
