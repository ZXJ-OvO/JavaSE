package com.daily.day08;

import java.util.Scanner;

/**
 * 题目1.键盘录入一个字符串,统计录入的字符串中的大写字母,小写字母,数字分别有多少个?
 */
public class Question01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = scanner.nextLine();
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int numberCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('a' <= c && c <= 'z') {
                lowerCaseCount++;
            }
            if ('A' <= c && c <= 'Z') {
                upperCaseCount++;
            }
        }
        numberCount = str.length() - upperCaseCount - lowerCaseCount;
        System.out.println("大写字母个数：" + upperCaseCount);
        System.out.println("小写字母个数：" + lowerCaseCount);
        System.out.println("纯数字的个数：" + numberCount);
    }
}
