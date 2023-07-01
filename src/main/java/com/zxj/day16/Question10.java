package com.zxj.day16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 如图所示:有四名学生参加注册会计师考试,表格中记录的是4名学生的考试成绩,请按照成绩将四名学生从小到大进行排名,并将结果展示出来.
 */
public class Question10 {
    public static void main(String[] args) {
        System.out.println("————————————————————————————————————类实现Comparator<T>外部比较器");
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        class Student implements Comparator<Student> {
            private String name;
            private int score;

            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore() - o2.getScore();
            }
        }

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("张三", 80));
        students.add(new Student("李四", 90));
        students.add(new Student("王五", 70));
        students.add(new Student("赵六", 60));

        // 1、使用类比较器通过Collections.sort(T, new T)排序
        Collections.sort(students, new Student());
        students.forEach(student -> System.out.println(student));

        // 2、使用匿名内部类，通过Collections.sort(T，new Comparator<T>)重写compare方法实现排序
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore() - o2.getScore();
            }
        });
        students.forEach(student -> System.out.println(student));

        // 3、使用匿名内部类，通过Arraylist自带的sort(new Comparator<T>())重写compare方法实现排序
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore() - o2.getScore();
            }
        });
        students.forEach(student -> System.out.println(student));


        System.out.println("————————————————————————————————————类实现Comparable内部比较器");
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        class Teacher implements Comparable<Teacher> {
            private String name;
            private int score;

            @Override
            public int compareTo(Teacher o) {
                return this.getScore() - o.getScore();
            }
        }

        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("张三", 80));
        teachers.add(new Teacher("李四", 90));
        teachers.add(new Teacher("王五", 70));
        teachers.add(new Teacher("赵六", 60));

        // 1、使用类实现的Comparable内部比较器重写compareTo方法，通过Collections.sort(T)排序
        Collections.sort(teachers);
        teachers.forEach(System.out::println);
    }
}
