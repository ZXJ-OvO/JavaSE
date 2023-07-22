package com.zxj.day16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Scanner;

public class Question19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<User> users = new HashSet<>();
        System.out.println("注册");

        users.add(new User("admin", "admin"));
        users.add(new User("root", "root"));
        users.add(new User("zxj", "zxj"));

        System.out.println("请输入账户名：");
        String name = scanner.next();

        for (User user : users) {
            if (user.getName().equals(name)) {
                System.out.println("名字重复");
                return;
            }
        }
        System.out.println("请输入密码");
        String pwd = scanner.next();
        users.add(new User(name, pwd));
        System.out.println("注册成功");

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private String name;
    private String pwd;
}