package com.zxj.day07;

/**
 * 需求 : 按照从小到大的顺序输出四位数中 (个位 + 百位 = 十位 + 千位 )  的数字及个数 , 要求使用while循环完成
 * 举例 : 3553 , 2332 , 1166 , 2233
 * while循环语句加if语句
 */
public class Question10 {
    public static void main(String[] args) {
        int i = 1000;
        while (i < 10000) {
            int ge = i / 1000 % 10;
            int shi = i / 100 % 10;
            int bai = i / 10 % 10;
            int qian = i / 1 % 10;
            int numLeft = ge + bai;
            int numRight = shi + qian;
            if (numLeft == numRight) {
                System.out.println(i + "\t");
            }
            i++;
        }
    }
}
