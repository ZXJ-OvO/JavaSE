package com.zxj.day14;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 二分查找
 * 定义变量记录左边和右边位置。
 * 使用while循环控制二分查询（条件是左边位置<=右边位置）
 * 循环内部获取中间元素索引
 * 判断当前要找的元素如果大于中间元素，左边位置=中间索引+1
 * 判断当前要找的元素如果小于中间元素，右边位置=中间索引-1
 * 判断当前要找的元素如果等于中间元素，返回当前中间元素索引
 */
public class Question03 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 1, 3, 5, 89, 23};
        // 二分查找要求是有序数列
        Arrays.sort(arr);
        System.out.println("排序后的数组为：" + Arrays.toString(arr));  // [1, 2, 3, 3, 3, 5, 7, 7, 23, 23, 32, 45, 78, 89, 89, 547]

        int num = new Scanner(System.in).nextInt();
        int left = 0;
        int right = arr.length - 1;
        int mid;
        boolean found = false;  // 添加一个标记来记录是否找到了元素
        while (left <= right) {
            mid = left + (right - left) / 2;  // 修正mid的计算方式
            if (num > arr[mid]) {
                left = mid + 1;
            } else if (num < arr[mid]) {
                right = mid - 1;
            } else {
                System.out.println("查找到的数" + num + "的索引是：" + mid);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("没有找到" + num);
        }
    }
}
