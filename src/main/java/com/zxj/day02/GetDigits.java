package com.zxj.day02;

/**
 * 求第几位就除位数模10
 * 求个位直接模10
 * 求十位除10 模10
 * 求百位除100 模10
 * 求千位除1000 模10
 * 求万位除10000 模10
 */
public class GetDigits {
    public static void main(String[] args) {
        int a = 1234;
        // 个位
        int ge = a % 10;
        System.out.println(ge);

        // 十位
        int shi = a / 10 % 10;
        System.out.println(shi);

        // 百位
        int bai = a / 100 % 10;
        System.out.println(bai);

        // 千位
        int qian = a / 1000 % 10;
        System.out.println(qian);
    }
}
