package com.zxj.day18;


/**
 * 需求：计算n的阶乘，5的阶乘=1*2*3*4*5;  6的阶乘=1*2*3*4*5*6；
 * 那么公式等价形式就是： f(n) = f(n-1) *n
 */
public class Question01 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    /**
     * 递归的公式： f(n) =  f(n-1) * n;
     * 递归的终结点：f(1)
     * 递归的方向必须走向终结点： f(n) =  f(n-1) * n;  f(n-1) = f(n-2) * (n-1)  f(n-2) = f(n-3) * (n-2)  ... f(1) = 1
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }
}
