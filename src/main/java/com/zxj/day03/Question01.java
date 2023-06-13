package com.zxj.day03;


/**
 * 水仙花数是一个三位数
 * 水仙花数的个位、十位、百位的数字立方和等于原数
 */
public class Question01 {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            // 个位
            int ge = i % 10;
            // 十位
            int shi = i / 10 % 10;
            // 百位
            int bai = i / 100;
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
                System.out.println("三位数中符合水仙花数的为：" + i);
            }
        }

    }
}
