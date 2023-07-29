package com.zxj.day16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.TreeSet;

public class Question13 {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("usa");
        treeSet.add("usd");
        treeSet.add("usa");
        System.out.println(treeSet);

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Dog implements Comparable<Dog> {
            private String name;
            private Integer age;
            private Double height;

            @Override
            public int compareTo(Dog o) {
                if (Objects.equals(this.age, o.age)) {
                    return this.height.compareTo(o.height);
                }
                return this.age - o.age;
            }
        }

        TreeSet<Dog> dogs = new TreeSet<>();
        dogs.add(new Dog("萨摩耶", 2, 1.2));
        dogs.add(new Dog("哈士奇", 1, 1.3));
        dogs.add(new Dog("黑柴", 3, 1.1));
        dogs.add(new Dog("黄柴", 3, 1.2));
        System.out.println(dogs);

        // TreeSet 方式一：实现 Comparable 接口，重写 compareTo 方法
        // TreeSet 方式二：实现 Comparator 接口，重写 compare 方法

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Teacher {
            private String name;
            private Integer age;
            private Double height;
        }

        TreeSet<Teacher> teachers = new TreeSet<>((o1, o2) -> {
            if (Objects.equals(o1.getAge(), o2.getAge())) {
                return o1.getHeight().compareTo(o2.getHeight());
            }
            return o1.getAge() - o2.getAge();
        });

        teachers.add(new Teacher("张三", 20, 1.8));
        teachers.add(new Teacher("李四", 21, 1.7));
        teachers.add(new Teacher("王五", 21, 1.6));
        teachers.add(new Teacher("赵六", 23, 1.5));
        System.out.println(teachers);

    }
}
