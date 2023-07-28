package com.zxj.day04;

/**
 * 定义一个数组其中包含多个数字。用自己的方式最终实现，
 * 奇数放在数组的左边，偶数放在数组的右边。（可以创建其他数组，不必须在原数组中改变）
 */
public class Question19 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        // 奇数个数
        int oddCount = 0;
        // 偶数个数
        int evenCount = 0;
        // 遍历数组，统计奇数和偶数个数
        for (int item : arr) {
            if (item % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }
        // 创建奇数数组
        int[] oddArr = new int[oddCount];
        // 创建偶数数组
        int[] evenArr = new int[evenCount];
        // 奇数数组下标
        int oddIndex = 0;
        // 偶数数组下标
        int evenIndex = 0;
        // 遍历数组，将奇数和偶数分别放入奇数数组和偶数数组
        for (int value : arr) {
            if (value % 2 == 0)
                evenArr[evenIndex++] = value;
            else
                oddArr[oddIndex++] = value;
        }
        // 打印奇数数组
        for (int k : oddArr) {
            System.out.print(k + " ");
        }
        System.out.println();
        // 打印偶数数组
        for (int j : evenArr) {
            System.out.print(j + " ");
        }
    }
}
