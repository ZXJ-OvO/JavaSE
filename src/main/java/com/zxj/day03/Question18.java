package com.zxj.day03;

/**
 * 有一个输出语句System.out.print("@")。使用这个语句，在控制台打印出一个五行的三角形，效果如下：
 */
public class Question18 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            // 打印每行的@符号
            for (int j = 1; j <= i; j++) {
                System.out.print("@");
            }
            // 换行
            System.out.println();
        }
    }
}
