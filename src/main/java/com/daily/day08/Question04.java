package com.daily.day08;

import java.util.Scanner;


/**
 * 题目四:
 * 我国手机号码都是11位的，现在需要定义一个方法，方法名称为checkPhone，方法内需要实现判断手机号码是否合法。
 * 规定：
 * 1) 手机号码长度必须为11位数字;
 * 2) 手机号码第一位必须要是1;
 * 键盘录入一个手机号码，在main方法中调用checkPhone方法，如果手机号符合要求，则输出手机号码的后四位。如果不符合要求，则提示手机号码错误。
 */
public class Question04 {
    public static void main(String[] args) {
        checkPhone(new Scanner(System.in).nextLine());
    }

    public static void checkPhone(String phone) {
        for (int i = 0; i < phone.length(); i++) {
            if (phone.charAt(i) < '0' || phone.charAt(i) > '9') {
                System.out.println("手机号码必须为数字");
                return;
            }
        }

        if (phone.length() != 11) {
            System.out.println("手机号码长度必须为11位数字");
        } else if (phone.charAt(0) != '1') {
            System.out.println("手机号码第一位必须要是1");
        } else {
            System.out.println("手机号码后四位为：" + phone.substring(7));
        }
    }

}