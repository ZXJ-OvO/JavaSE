package com.daily.day09;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * 第三题:
 * 一: 定义一个学生类, 包含  姓名  学科 成绩 三个属性
 * 创建三个学生对象
 * 张三, 语文 78;
 * 李四, 语文 68;
 * 王五, 语文 98;
 * 把三个学生对象添加到list集合中
 * 1.打印出 语文成绩最高的分数
 * 2. 求三名学生语文成绩的平均值(不考虑小数)
 */
public class Question03 {
    public static void main(String[] args) {
        @NoArgsConstructor
        @Data
        @AllArgsConstructor
        class Student {
            private String name;
            private String subject;
            private int score;
        }

        ArrayList<Student> students = new ArrayList<>();

        Student student1 = new Student("张三", "语文", 78);
        Student student2 = new Student("李四", "语文", 68);
        Student student3 = new Student("王五", "语文", 98);

        students.add(student1);
        students.add(student2);
        students.add(student3);

        students.sort((o1, o2) -> o2.getScore() - o1.getScore());
        System.out.println("语文成绩最高的分数: " + students.get(0).getScore());
        System.out.println("三名学生语文成绩的平均值: " + (student1.getScore() + student2.getScore() + student3.getScore()) / 3);
    }
}
