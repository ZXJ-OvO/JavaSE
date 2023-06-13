package com.zxj.day03;

import java.util.Scanner;

/**
 * 需求: 键盘录入用户密码, 如果密码为 111111, 程序输出密码正确，否则输出密码有误
 */
public class Question03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("请输入密码：");
            String password = in.nextLine();
            if (password.equals("111111")) {
                System.out.println("密码正确");
                break;
            } else {
                System.out.println("密码错误");
            }
        }
    }
}
