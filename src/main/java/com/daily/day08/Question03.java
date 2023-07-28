package com.daily.day08;

import java.util.Scanner;

/**
 * 题目3:
 * 定义一个String类型的数组,长度为3,利用键盘录入为其赋值
 * 定义一个方法,功能如下,外界传入一个字符串数组,该方法能够将该数组中所有长度小于3的元素打印出来
 * 在主方法中调用该方法,传入我们准备好的数组,将满足条件的元素打印出来
 */
public class Question03 {
    public static void main(String[] args) {
        String[] s = new String[3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < s.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个字符串");
            s[i] = scanner.nextLine();

        }
        getString(s);
    }

    public static void getString(String[] strings) {
        System.out.println("字符串数组中长度小于3的元素有：");
        for (String string : strings) {
            if (string.length() < 3 && !string.contains(" ")) {
                System.out.print(string + " \t");
            }
        }
    }
}
