package com.daily.day10;

import java.util.Random;
import java.util.Scanner;

/**
 * 在登录注册页面中，除了用户名和密码外，通常也会包含验证码。验证码是用来区分用户是计算机还是人，防止恶意破解密码、刷票、灌水等行为。
 * 在判断验证码时一般不区分大小写。请编写程序模拟验证码的判断过程，
 * 如果输入正确，给出提示，结束程序。
 * 如果输入错误，给出提示，验证码刷新，重新输入，直至正确为止。
 * 《定义方法，获取一个包含4个字符的验证码，每一位字符是随机选择的字母和数字，可包含a-z,A-Z,0-9。》
 * 运行效果如下：
 * 生成的验证码为：BkhD
 * 请输入验证码
 * abcd
 * 输入错误，请重新输入...
 * 生成的验证码为：Fm1a
 * 请输入验证码
 * fm1a
 * 输入正确
 */
public class Question03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputCode;
        do {
            String code = verificationCode();
            System.out.println("生成的验证码为：" + code);
            System.out.println("请输入验证码");
            inputCode = scanner.nextLine();
            if (inputCode.equalsIgnoreCase(code)) {
                System.out.println("输入正确");
                break;
            } else {
                System.out.println("输入错误，请重新输入...");
            }

        } while (true);
    }

    public static String verificationCode() {
        String code = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(code.length());
            stringBuilder.append(code.charAt(index));
        }
        return stringBuilder.toString();
    }
}
