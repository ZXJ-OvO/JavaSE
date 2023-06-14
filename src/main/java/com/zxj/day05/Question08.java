package com.zxj.day05;

/**
 * 定义一个方法，该方法能够找出三个整数中的最大值并返回。在主方法中调用方法测试执行。
 */
public class Question08 {
    public static void main(String[] args) {
        int max = getMax(1, 2, 3);
        System.out.println(max);
    }

    public static int getMax(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        } else if (c > max) {
            max = c;
        }
        return max;
    }
}
