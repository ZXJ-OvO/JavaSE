package com.zxj.day08;

import java.util.Random;

/**
 * 实现随机产生验证码，验证码的每位可能是数字、大写字母、小写字母。
 */
public class Question05 {
    public static void main(String[] args) {
        String verification = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int index = r.nextInt(verification.length());
            System.out.print(verification.charAt(index));
        }
    }
}
