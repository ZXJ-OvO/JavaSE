package com.zxj.day13;

import com.customer.BigDecimalUtil;

/**
 * 请并且给出精确输出(得到结果为0.2)的代码！
 */
public class Question17 {
    public static void main(String[] args) {
        double a = 0.17;
        double b = 0.23;
        double divide = BigDecimalUtil.divide(a, b);
        System.out.println(divide);
    }
}
