package com.zxj.day06;

/**
 * 除了1和它本身以外，不能被其他正整数整除，就叫素数。
 */
public class Question08 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 101; i <= 200; i++) {
            boolean flag = true;
            // 不是素数的条件：能被2到i-1之间的任意一个数整除
            for (int j = 2; j < i; j++) {
                if (i % j == 0) { // 不是素数
                    flag = false;
                    break; // 当前的数在本轮判断中已经不是素数了，就不用再判断了，直接跳出循环
                }
            }
            if (flag) {
                count++;
                System.out.print(i + "\t");
                if (count % 5 == 0) { // 每5个换行，格式化显示
                    System.out.println();
                }
            }
        }
    }
}
