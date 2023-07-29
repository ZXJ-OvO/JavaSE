package com.zxj.day16;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

public class Question17 {
    public static void main(String[] args) {
        ArrayList<Student> students = CollUtil.newArrayList(
                new Student(1, "张三", 90),
                new Student(2, "李四", 80),
                new Student(3, "王五", 70),
                new Student(4, "赵六", 60),
                new Student(5, "田七", 50));

        students.sort(Student::compareTo);
        System.out.println(students);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int score;

    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }
}