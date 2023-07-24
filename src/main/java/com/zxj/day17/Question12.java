package com.zxj.day17;

/**
 * 目标：递归的算法基础：解决求阶乘。
 */
public class Question12 {
    public static void main(String[] args) {
        System.out.println(f(5));
    }



    public static int f(int n) {
        if (n == 1) {
            return 1;
        } else {
            return f(n - 1) * n;
        }
    }
}
