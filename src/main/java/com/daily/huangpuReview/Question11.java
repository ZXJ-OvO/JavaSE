package com.daily.huangpuReview;

/**
 * 定义一个方法，传递一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 x 使得 n == 2的x次方，则认为 n 是 2 的幂次方。
 * <p>
 * 扩展：3的幂  4的幂
 */
public class Question11 {
    public static void main(String[] args) {
        System.out.println(check(1));
        System.out.println(check(16));
        System.out.println(check(0));
        System.out.println(check(3));
    }

    public static boolean check(int number) {
        if (number <= 0) return false;
        return (number & (number - 1)) == 0;
    }
}