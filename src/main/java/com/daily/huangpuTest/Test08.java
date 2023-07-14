package com.daily.huangpuTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 在ArrayList中添加5个学生对象，学生的属性为：id，name，age。
 * 要求1：
 * 添加学生对象的时候，id要唯一，不能重复。
 * 要求2：
 * 查询id为：heima001的学生是否存在
 * 如果存在，返回学生对象
 * 如果不存在，返回null
 */
public class Test08 {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        addStudents(students);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生id");
        String id = sc.next();
        Student s = getStudentById(id, students);
        if (s != null) {
            System.out.println("录入的信息为：" + s.getId() + "\t" + s.getName() + "\t" + s.getAge());
        } else {
            System.out.println("您的输入有误");
        }
    }

    private static void addStudents(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            Student s = new Student();
            System.out.println("请输入第" + i + "个学生的信息");
            while (true) {
                System.out.println("请输入学生id");
                String id = sc.nextLine();

                Student s2 = getStudentById(id, students);
                if (s2 != null) {
                    System.out.println("id重复请重新输入");
                } else {
                    s.setId(id);
                    break;
                }
            }

            System.out.println("请输入学生姓名");
            String name = sc.next();
            s.setName(name);

            System.out.println("请输入学生年龄");
            int age = sc.nextInt();
            s.setAge(age);
            students.add(s);
        }
    }

    private static Student getStudentById(String id, ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student {
    private String id;
    private String name;
    private int age;
}