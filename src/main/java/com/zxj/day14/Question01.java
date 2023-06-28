package com.zxj.day14;

/**
 * 冒泡排序：每次找到最大值放到数组后面
 * 1、确定一共需要比较多少轮：数组长度-1
 * 2、确定每轮比较多少次：数组长度-1-轮数
 * 3、确定每次比较的两个数的下标：i和i+1
 * 4、比较两个数的大小，如果前面的数大于后面的数，交换位置
 */
public class Question01 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 1, 78, 3, 5, 89, 3, 45, 7, 89, 23, 32, 547, 23};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = 0; k < arr.length - 1 - i; k++) {
                if (arr[k] > arr[k + 1]) {
                    arr[k] = arr[k] ^ arr[k + 1];
                    arr[k + 1] = arr[k + 1] ^ arr[k];
                    arr[k] = arr[k] ^ arr[k + 1];
                }
            }
        }
        System.out.println("排序后的数组为：" + java.util.Arrays.toString(arr));
    }
}
