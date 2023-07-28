package com.zxj.day08;

import java.util.Scanner;

/**
 * 请编写程序，由键盘录入一个字符串，统计字符串中英文字母和数字分别有多少个。
 * 比如：Hello12345World中字母：10个，数字：5个。
 * ASCII:
 * 0-9：48-57
 * A-Z：65-90
 * a-z：97-122
 * 中文：0-65535
 */
public class Question10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串（支持中文、字母、数字）：");
        String str = sc.nextLine();
        char[] charArray = str.toCharArray();
        for (char value : charArray) {
            System.out.print(value + " ");
        }
        int en = 0;
        int cn = 0;
        int num = 0;
        for (char c : charArray) {
            if ((65 <= c && c <= 90) || (97 <= c && c <= 122)) {
                en++;
            } else if (48 <= c && c <= 57) {
                num++;
            } else {
                cn++;
            }
        }
        System.out.println("英文字母：" + en + "个，数字：" + num + "个，中文：" + cn + "个。");
    }
}
