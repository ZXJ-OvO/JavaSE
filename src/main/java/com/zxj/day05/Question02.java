package com.zxj.day05;

import java.util.Scanner;

/**
 * 判断一个整数是奇数还是偶数，并把判断的结果输出出来。
 */
public class Question02 {
    public static void main(String[] args) {
        System.out.print("请输入一个整数以判断奇偶：");
        isOddOrEven(new Scanner(System.in).nextInt());
    }

    public static void isOddOrEven(int num) {
        if(num % 2 == 0) {
            System.out.println("偶数");
        } else {
            System.out.println("奇数");
        }
    }
}
