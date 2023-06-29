package com.zxj.day15;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 有4个人参加公务员考试,考试成绩如图所示,录取3名学生,淘汰分数最低的一名,设计一个程序,完成需求
 * 1 99 刘备
 * 2 85 关羽
 * 3 90 张飞
 * 4 75 诸葛
 */
public class Question06 {
    public static void main(String[] args) {
        @AllArgsConstructor
        @Data
        @NoArgsConstructor
        class Student implements Comparable<Student> {
            int id;
            int score;
            String name;

            @Override
            public int compareTo(Student o) {
                return this.score - o.score;
            }
        }

        TreeSet<Student> treeSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore() - o2.getScore();
            }
        });

        treeSet.add(new Student(1, 99, "刘备"));
        treeSet.add(new Student(2, 85, "关羽"));
        treeSet.add(new Student(3, 90, "张飞"));
        treeSet.add(new Student(4, 75, "诸葛"));

        treeSet.stream().sorted().forEach(student -> System.out.println(student));

        System.out.println("淘汰分数最低的一名");
        treeSet.pollFirst(); // pollFirst()方法返回并删除第一个元素
        treeSet.stream().sorted().forEach(student -> System.out.println(student));

    }
}
