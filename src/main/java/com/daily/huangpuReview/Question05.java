package com.daily.huangpuReview;

import java.util.Scanner;

/**
 * 需求：
 * 给你两个整数，被除数dividend和除数divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。
 * 例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 * 返回被除数dividend除以除数divisor得到的 商 。
 */
public class Question05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividend = scanner.nextInt();
        int divisor = scanner.nextInt();
        int flagDividend = 0;
        int flagDivisor = 0;
        int flagBoth = 0;
        int quotient = 0;

        if (dividend == 0) {
            System.out.println("invalid");
            return;
        } else if (divisor == 0) {
            System.out.println(divisor);
            return;
        } else if (dividend == divisor) {
            System.out.println(1);
            return;
        }

        if (divisor < 0 && dividend > 0) {
            divisor = divisor * (-1);
            flagDivisor = 1;
        } else if (dividend < 0 && divisor > 0) {
            dividend = dividend * (-1);
            flagDividend = 1;
        } else if (divisor < 0) {
            divisor = divisor * (-1);
            dividend = dividend * (-1);
            flagBoth = 1;
        }

        while (divisor <= dividend) {
            quotient++;
            dividend -= divisor;
        }

        if (flagDivisor == 1) {
            System.out.println(quotient * (-1));
        } else if (flagDividend == 1) {
            System.out.println(quotient * (-1));
        } else if (flagBoth == 1) {
            System.out.println(quotient);
        }else {
            System.out.println(quotient);
        }
    }
}
