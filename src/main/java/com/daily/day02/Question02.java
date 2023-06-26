package com.daily.day02;

import java.util.Scanner;

/**
 * 题目2：有两只老虎，键盘录入两只老虎的体重，请用程序判断两只老虎的体重是否相同
 */
public class Question02 {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("依次回车输入两只老虎的体重，系统将判断二者体重是否相等：");
        System.out.println(sc.nextDouble() == sc.nextDouble() ? "相同" : "不同");
    }
}
