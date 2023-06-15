package com.zxj.day07;

import java.util.Scanner;

/**
 * #### 题目二:
 * 需求 : 假设一个简单的在ATM的取款过程如下：
 * - 提示用户输入金额（money）
 * - ATM只能输出100元的纸币一次取钱数要求最低0元，最高10000元。
 * - 如果用户输入的金额符合上述要求，则打印输出用户取的钱数
 * - 如果输入的取款金额有误, 请给出提示并继续录入, 直到用户输入正确为止
 * - 考察:循环语句、if 语句、break语句
 */
public class Question09 {
    public static void main(String[] args) {
        boolean status = false;
        while (!status) {
            System.out.println("输入操作金额：");
            int nextInt = new Scanner(System.in).nextInt();
            if (0 <= nextInt && nextInt <= 10000) {
                System.out.println("本次操作的金额：" + nextInt);
                status = true;
            } else {
                System.out.println("\n输入有误");
                System.out.println("本系统操作金额下限0元，上限10000元\n");
            }
        }
    }
}
