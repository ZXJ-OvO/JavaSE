package com.zxj.day18;


/**
 * 需求：计算n的阶乘，5的阶乘=1*2*3*4*5;  6的阶乘=1*2*3*4*5*6；
 * 那么公式等价形式就是： f(n) = f(n-1) *n
 * f(5) = f(4) * 4
 * f(4) = f(3) * 3
 * f(3) = f(2) * 2
 * f(2) = f(1) * 1
 * f(1) = 1 // 递归的结束条件
 */
public class Question01 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    private static int factorial(int i) {
        if(i == 1){
            return 1;
        }
        return factorial(i - 1) * i;
    }

}
