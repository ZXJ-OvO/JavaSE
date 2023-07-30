package com.zxj.day16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 学生属性姓名和年龄，按照年龄进行排序并遍历。
 * 定义学生类
 * 创建TreeMap集合对象
 * 创建学生对象
 * 把学生添加到集合
 * 遍历集合
 * TreeMap 自定义比较器只是实现了自定义的键的排序，而不是值的排序
 */
public class Question06 {

    public static void main(String[] args) {
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        class Students implements Comparable<Students> {
            private String name;
            private Integer age;

            @Override
            public int compareTo(Students o) {
                return this.age - o.age;
            }
        }

        Students students1 = new Students("张三", 23);
        Students students2 = new Students("李四", 18);
        Students students3 = new Students("王五", 20);

        TreeMap<Students, Integer> treeMap = new TreeMap<>(Comparator.comparingInt(Students::getAge));


        treeMap.put(students1, students1.getAge());
        treeMap.put(students2, students2.getAge());
        treeMap.put(students3, students3.getAge());

        System.out.println("按照年龄排序后的结果为：");
        treeMap.forEach((k, v) -> System.out.println(k + " " + v));

    }
}
