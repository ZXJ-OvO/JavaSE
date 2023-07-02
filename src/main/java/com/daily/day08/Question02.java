package com.daily.day08;

import java.util.Scanner;

/**
 * 题目2.通过键盘录入两个字符串,使用StringBuilder,将两个字符串反转,把他们的结果拼接起来,达到如下效果:
 * 输入:"abc"
 * 输入:"123"
 * 结果:"cba321"
 */
public class Question02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个字符串");
        StringBuilder word1 = new StringBuilder(scanner.nextLine());
        System.out.println("输入另一个字符串");
        StringBuilder word2 = new StringBuilder(scanner.nextLine());
        word1.reverse();
        word2.reverse();
        System.out.println(word1.append(word2));
    }
}
