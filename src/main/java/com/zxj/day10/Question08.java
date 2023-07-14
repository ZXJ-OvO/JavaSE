package com.zxj.day10;

import lombok.Data;

public class Question08 {
    public static void main(String[] args) {
        Student student = new Student();

        Student.name = "Java";

        student.setAge(10);
        System.out.println(student);

        Student student1 = new Student();
        student1.setAge(20);
        System.out.println(student1);

        // 不建议使用
        student1.name = "static内存只有一份";
    }
}

@Data
class Student {
    static String name;
    Integer age;
}