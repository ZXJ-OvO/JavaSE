package com.zxj.day03;

/**
 * 需求：在控制台使用 * 打印出4行5列的矩形
 */
public class Question07 {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();


        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
