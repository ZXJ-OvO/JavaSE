package com.zxj.day08;

import java.util.Scanner;

/**
 * 系统正确的登录名和密码是：itheima/123456，
 * 请在控制台开发一个登录界面，接收用户输入的登录名和密码，
 * 判断用户是否登录成功，登录成功后展示：“欢迎进入系统!”，即可停止程序
 * （注意：要求最多给用户三次登录机会）
 */
public class Question04 {
    public static void main(String[] args) {
        String username = "itheima";
        String password = "123456";
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入账号：");
            String s = sc.nextLine();
            System.out.println("请输入密码：");
            String p = sc.nextLine();
            if (s.equals(username)) {
                if (p.equals(password)) {
                    System.out.println("登录成功！");
                    break;
                } else {
                    System.out.println("密码错误");
                    System.out.println("您还有：" + (3 - 1 - i) + "次机会");
                }
            } else {
                System.out.println("用户名错误");
                System.out.println("您还有：" + (3 - 1 - i) + "次机会");
            }
        }
    }
}
