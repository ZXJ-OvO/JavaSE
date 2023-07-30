package com.zxj.day10;

import java.util.Random;

public class Question11 {
    public static void main(String[] args) {
        System.out.println("验证码为：" + CustomerToolBox.getVerificationCode());
        System.out.println("验证码为：" + CustomerToolBox.getVerificationCode());
        System.out.println("验证码为：" + CustomerToolBox.getVerificationCode());
    }
}

class CustomerToolBox {
    private static final Random random = new Random();

    // 工具类不需要创建对象，则将构造器私有
    private CustomerToolBox() {
    }

    public static String getVerificationCode() {
        String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(data.length());
            code.append(data.charAt(index));
        }

        return code.toString();
    }
    // 199 7269 1090
    // 124 5588 532
}

