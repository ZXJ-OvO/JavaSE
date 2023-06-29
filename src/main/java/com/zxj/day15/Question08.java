package com.zxj.day15;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 模拟注册用户,如果存在要注册的用户,直接显示"对不起,您注册的用户已经存在!请直接登录!",可以继续注册;
 * 如果不存在要注册的用户,显示"注册成功!",并将所有用户的信息显示出来!
 */
public class Question08 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        boolean status = true;
        while (status) {
            System.out.println("请输入您的用户名:");
            String nextLine = new Scanner(System.in).nextLine();
            if (list.contains(nextLine)) {
                System.out.println("对不起,您注册的用户已经存在!请直接登录!");
                break;
            }
            if (!(list.contains(nextLine))) {
                list.add(nextLine);
                System.out.println("注册成功!");
                continue;
            }
            status = false;
        }
    }
}
