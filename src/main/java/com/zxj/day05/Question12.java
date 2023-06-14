package com.zxj.day05;

/**
 * 数字是有绝对值的，负数的绝对值是它本身取反，非负数的绝对值是它本身。
 * 请定义一个方法，方法能够得到小数类型数字的绝对值并返回。请定义方法并测试。
 */
public class Question12 {
    public static void main(String[] args) {
        System.out.println(getAbsoluteValue(-1.2));
    }

    public static double getAbsoluteValue(double num) {
        return num < 0 ? -num : num;
    }
}
