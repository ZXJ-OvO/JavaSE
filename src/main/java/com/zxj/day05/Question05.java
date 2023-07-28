package com.zxj.day05;

/**
 * 把找出数组的最大值案例，改造成方法，可以支持返回任意整型数组的最大值数据。
 */
public class Question05 {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 21, 555, 34, 23, 21};
        System.out.println(findMaxNumber(array));
    }

    public static int findMaxNumber(int[] array) {
        int max = array[0];
        for (int j : array) {
            if (max < j) {
                max = j;
            }
        }
        return max;
    }
}
