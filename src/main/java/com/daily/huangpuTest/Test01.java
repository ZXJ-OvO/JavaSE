package com.daily.huangpuTest;

/**
 * 需求：
 * 在请统计所有“水仙花数”的个数，水仙花数必须满足如下2个要求：
 * 要求1：
 * 水仙花数是一个三位数 100 999
 * 要求2：
 * 水仙花数的个位、十位、百位的数字立方和等于原数
 */
public class Test01 {
    public static void main(String[] args) {
        int ge;
        int shi;
        int bai;
        int sum;


        for (int i = 100; i < 1000; i++) {
            ge = i % 10;
            shi = i / 10 % 10;
            bai = i / 100 % 10;
            sum = ge * ge * ge + shi * shi * shi + bai * bai * bai;

            if (sum == i) {
                System.out.print(i + " ");
            }
        }

    }
}
