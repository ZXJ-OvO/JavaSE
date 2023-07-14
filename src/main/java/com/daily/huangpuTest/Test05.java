package com.daily.huangpuTest;

import java.util.Scanner;

/**
 * 定义两个变量记录正确的用户名和密码，分别为：zhangsan，123456
 * 利用键盘录入，模拟用户登录功能，最多只给三次机会。
 * 按照不同的情况进行如下提示：
 * •	如果用户名密码输入正确
 * 提示：登录成功
 * •	用户名密码输入错误，还没有到三次
 * 提示：用户名或密码输入错误，您还剩下2次机会
 * •	用户名密码输入错误，已经到达三次
 * 提示：用户名或密码输入错误，账户：XXX被锁定请联系客服
 */
public class Test05 {
    public static final String name = "zhangsan";

    public static final String pwd = "123456";

    public static Integer count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入账户名");
            String nameInput = scanner.nextLine();
            System.out.println("请输入密码");
            String pwdInput = scanner.nextLine();

            Integer check = check(nameInput, pwdInput);
            if (check == 1) {
                break;
            }
            if (count == 3) {
                System.out.println("用户名或密码输入错误，账户：" + name + "被锁定请联系客服");
                break;
            }
        }
    }

    public static Integer check(String nameInput, String pwdInput) {
        if (name.equals(nameInput) && pwd.equals(pwdInput)) {
            System.out.println("登录成功");
            return 1;
        } else {
            count++;
            System.out.println("用户名或密码输入错误，您还剩下" + (3 - count) + "次机会");
            return 0;
        }
    }
}
