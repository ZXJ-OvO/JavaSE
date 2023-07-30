package com.daily.huangpuTest;

import java.util.Random;

/**
 * 需求：
 * 定义方法getCode，返回一个长度为5的验证码。
 * 验证码要求：
 * 长度为5，内容随机
 * 每位可能是数字、大写字母、小写字母。
 * 调用该方法，并将结果打印出来
 */
public class Test04 {
    public static void main(String[] args) {
        System.out.println(getCode());
    }

    public static String getCode() {
        String code = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random random = new Random();

        StringBuilder s = new StringBuilder();


        for (int i = 0; i < 5; i++) {

            s.append(code.charAt(random.nextInt(code.length())));
        }
        return s.toString();
    }
}
