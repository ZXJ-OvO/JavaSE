package com.zxj.day03;

import java.math.BigDecimal;

/**
 * 水仙花数是一个三位数
 * 水仙花数的个位、十位、百位的数字立方的和等于原数
 */
public class NumberOfDaffodils {
    public static void main(String[] args) {
        System.out.println(checkNumber(153));

    }

    public static boolean checkNumber(int num) {
        int ge = num % 10;
        int shi = num / 10 % 10;
        int bai = num / 100 % 10;

        double pow1 = Math.pow(ge, 3);
        double pow2 = Math.pow(shi, 3);
        double pow3 = Math.pow(bai, 3);

        BigDecimal add = BigDecimal.valueOf(pow3).add(BigDecimal.valueOf(pow1).add(BigDecimal.valueOf(pow2)));
        double v = add.doubleValue();

        return v == num;
    }
}
