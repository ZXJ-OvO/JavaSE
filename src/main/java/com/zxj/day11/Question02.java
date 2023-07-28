package com.zxj.day11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 请设计一个班级学生的信息管理模块：学生的数据有：姓名、性别、成绩
 * 功能1：要求打印出全班学生的信息； 功能2：要求打印出全班学生的平均成绩。
 */
public class Question02 {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("张三");
        student1.setGender("男");
        student1.setScore(100.0);

        Student student2 = new Student();
        student2.setName("李四");
        student2.setGender("女");
        student2.setScore(90.0);

        Student student3 = new Student();
        student3.setName("王五");
        student3.setGender("男");
        student3.setScore(80.0);

        Student student4 = new Student();
        student4.setName("赵六");
        student4.setGender("女");
        student4.setScore(70.0);

        Student student5 = new Student();
        student5.setName("田七");
        student5.setGender("男");
        student5.setScore(60.0);

        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);

        StudentInfoSystemImpl system = new StudentInfoSystemImpl();
        System.out.println("输入操作指令");
        system.switchCase(new Scanner(System.in).nextInt(), list);

    }
}

class StudentInfoSystemImpl implements StudentInfoSystem {
    public void switchCase(int i, List<Student> students) {
        switch (i) {
            case 1:
                print(students);
                break;
            case 2:
                avgWithoutMaxMin(students);
                break;
            default:
                System.out.println("输入错误");
        }
    }

    @Override
    public void print(List<Student> students) {
        double score = 0;
        for (Student student : students) {
            score += student.getScore();
            System.out.println(student.toString());
        }
        System.out.println("全班平均成绩为：" + score / students.size());
    }

    public void avgWithoutMaxMin(List<Student> students) {
        double max = students.get(0).getScore();
        double min = students.get(0).getScore();
        double score = 0;

        for (Student student : students) {

            score += student.getScore();

            if (student.getScore() < min) {
                min = student.getScore();

            }
            System.out.println("最低分为：" + min);

            if (student.getScore() > max) {
                max = student.getScore();
            }
            System.out.println("最高分为：" + max);
        }

        double end = (score - max - min) / (students.size() - 2);
        System.out.println("去掉最高分、最低分后全班的平均分数是：" + end);

    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    String name;
    String gender;
    Double score;
}

// 接口可以多继承，但是类只能单继承
interface StudentInfoSystem extends A, B {
    public static int a = 0;

    void print(List<Student> students);
}

interface A {

}

interface B {

}
