package com.zxj.day05;

/**
 * 请定义一个方法，对正数的小数进行四舍五入的操作(不考虑负数情况)。
 * 四舍五入之后的结果是一个int整数类型并返回。最后对方法进行测试。
 */
public class Question13 {
    public static void main(String[] args) {
        System.out.println(round(1.2));
        System.out.println(round(1.6));
    }

    public static int round(double num) {
        return (int) (num + 0.5);
    }
}
