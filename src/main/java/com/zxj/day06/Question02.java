package com.zxj.day06;

import java.util.Scanner;

/**
 * 开发一个程序，可以生成指定位数的验证码，每位可以是数字、大小写字母。
 */
public class Question02 {
    public static void main(String[] args) {
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        int nextInt = new Scanner(System.in).nextInt();
        for (int i = 0; i < nextInt; i++) {
            int index = (int) (Math.random() * str.length());
            code += str.charAt(index); //catAt()返回指定索引处的char值
        }
        System.out.println(code);
    }
}
