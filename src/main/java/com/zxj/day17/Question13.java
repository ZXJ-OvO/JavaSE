package com.zxj.day17;

/**
 * 1到n的和
 */
public class Question13 {
    public static void main(String[] args) {
        System.out.println(f(5));
    }

    public static int f(int n) {
        if (n == 1) {
            return n;
        } else {
            return f(n - 1) + n;
        }
    }
}
