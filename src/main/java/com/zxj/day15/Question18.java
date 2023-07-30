package com.zxj.day15;

import com.customer.BigDecimalUtil;

import java.util.Scanner;

public class Question18 {
    public static void main(String[] args) {
        double balance = 5000.0;
        System.out.println("请输入取钱金额：");
        Scanner scanner = new Scanner(System.in);

        double v;
        while (true) {
            try {
                v = scanner.nextDouble();
                if (v > balance) {
                    throw new RuntimeException("余额不足");
                }
                break;
            } catch (Exception e) {
                throw new RuntimeException("输入的金额不合法");
            }
        }

        System.out.println("余额为：" + BigDecimalUtil.subtract(balance, v));
    }
}
