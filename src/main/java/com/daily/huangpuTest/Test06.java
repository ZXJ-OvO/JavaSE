package com.daily.huangpuTest;

import java.util.Scanner;

/**
 * 键盘录入一个字符串，分别统计出其中大写英文字母、小写英文字母、数字和其它字符的个数。
 * 举例：
 * 键盘输入：aweihaoshuai1234ZHESHIDANGRANDE!!!
 * 打印结果：
 * 大写字母： 15个
 * 小写字母：12个
 * 数字：4个
 * 其他字符：3个
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();

        int big = 0;
        int small = 0;
        int num = 0;
        int other = 0;

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                big++;
            } else if (c >= 'a' && c <= 'z') {
                small++;
            } else if (c >= '0' && c <= '9') {
                num++;
            } else {
                other++;
            }
        }

        System.out.println("大写字母：" + big + "个");
        System.out.println("小写字母：" + small + "个");
        System.out.println("数字：" + num + "个");
        System.out.println("其他字符：" + other + "个");
    }
}
