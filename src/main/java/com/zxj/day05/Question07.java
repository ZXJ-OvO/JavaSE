package com.zxj.day05;

/**
 * 定义一个方法，该方法能够找出两个小数中的较小值并返回。在主方法中调用方法进行测试。
 */
public class Question07 {
    public static void main(String[] args) {
        System.out.println(findMin(1.2, 2.3));
    }
    public static double findMin(double a, double b) {
        return Math.min(a, b);
    }
}
