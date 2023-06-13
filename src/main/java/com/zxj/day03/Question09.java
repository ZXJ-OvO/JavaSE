package com.zxj.day03;

/**
 * 系统密码是520，请用户不断地输入密码验证，
 * 验证不对输出：密码错误，
 * 验证成功输出：欢迎进入系统，并停止程序。
 */
public class Question09 {
    public static void main(String[] args) {
        String password = "520";
        while (true) {
            System.out.println("请输入密码：");
            String input = new java.util.Scanner(System.in).nextLine();
            if (input.equals(password)) {
                System.out.println("欢迎进入系统");
                break;
            } else {
                System.out.println("密码错误");
            }
        }
    }
}
