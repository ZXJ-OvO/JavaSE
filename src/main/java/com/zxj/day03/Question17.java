package com.zxj.day03;

/**
 * 有一个输出语句System.out.print("@")。使用这个语句，在控制台打印出一个四行五列的长方形
 */
public class Question17 {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                System.out.print("@");
                if (i1 == 4) {
                    System.out.println();
                }
            }
        }
    }
}
