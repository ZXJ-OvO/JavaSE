package com.zxj.day17;

/**
 * 猴子吃桃问题
 * f(n - 1) = f(n) - f(n) / 2 - 1
 * f(n) = 2 * f(n + 1) + 2
 */
public class Question14 {
    public static void main(String[] args) {
        System.out.println(f(1));
    }

    public static int f(int n) {
        if (n == 10) {
            return 1;
        } else {
            return 2 * f(n + 1) + 2;
        }
    }
}
