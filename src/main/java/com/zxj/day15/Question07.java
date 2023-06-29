package com.zxj.day15;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * 如图,表格中是三年级一班的学生信息,后来张三丰移民到了山东,李老师需要将张三丰对应的住址改掉,请用程序完成需求,并将学生的信息打印到控制台上
 * 1 深圳 刘备
 * 2 广州 关羽
 * 3 北京 张飞 --> 美国
 * 4 上海 诸葛
 */
public class Question07 {
    public static void main(String[] args) {
        @AllArgsConstructor
        @Data
        @NoArgsConstructor
        class Student {
            int id;
            String address;
            String name;
        }
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "深圳", "刘备"));
        students.add(new Student(2, "广州", "关羽"));
        students.add(new Student(3, "北京", "张飞"));
        students.add(new Student(4, "上海", "诸葛"));
        System.out.println(students.toString());
        // students.stream().filter(student -> student.getName().equals("张飞")).forEach(student -> student.setAddress("美国"));
        students.set(2, new Student(3, "美国", "张飞"));
        System.out.println(students.toString());
    }
}
