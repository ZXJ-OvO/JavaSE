package com.zxj.day15;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Scanner;

public class Question14 {
    public static void main(String[] args) {
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Student {
            private String name;
            private String password;
        }

        ArrayList<Student> students = CollUtil.newArrayList(new Student("张三", "123"),
                new Student("李四", "456"),
                new Student("王五", "789"),
                new Student("赵六", "101112"),
                new Student("田七", "131415"));

        Scanner scanner = new Scanner(System.in);

        System.out.println(students);

        OUT:
        while (true) {
            Console.log("请输入账户名！：");
            String inputName = scanner.next();
            for (Student student : students) {
                if (student.getName().equals(inputName)) {
                    Console.log("已经存在同名的账户，请重新输入");
                    continue OUT;
                }
            }
            Console.log("输入密码完成注册");
            String pwd = scanner.next();
            students.add(new Student(inputName, pwd));
            System.out.println("注册成功");
            return;
        }
    }
}
