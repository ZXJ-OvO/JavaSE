package com.zxj.day15;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * 创建一个存储学生对象的集合，存储多个学生对象，使用程序实现在控制台遍历该集合，
 * 要求：学生对象的成员变量值相同，我们就认为是同一个对象
 */
public class Question05 {
    public static void main(String[] args) {
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Student implements Comparable<Student> {
            private String name;
            private Integer age;

            @Override
            public int compareTo(Student o) {
                return this.age - o.age;
            }
        }

        Student student1 = new Student("关羽", 89);
        Student student2 = new Student("曹操", 64);
        Student student3 = new Student("曹操", 64);

        System.out.println("----------------------------------------HashSet：基于哈希表，底层使用数组+链表+红黑树   无序、不重复、无索引");
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(student1);
        hashSet.add(student2);
        hashSet.add(student3);
        // lombok重写了hashCode()和equals()方法，完全一样的两个对象student2和student3会被当成一个对象，达到去重的效果
        hashSet.forEach(student -> System.out.println(student));

        System.out.println("----------------------------------------LinkedHashSet：基于哈希表，底层使用数组+链表+红黑树   有序、不重复、无索引");
        LinkedHashSet<Student> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(student1);
        linkedHashSet.add(student2);
        linkedHashSet.add(student3);
        linkedHashSet.forEach(student -> System.out.println(student));

        System.out.println("----------------------------------------TreeSet：基于红黑树  可排序、不重复、无索引");
        // 通过有参构造器实现Comparator接口，重写compare()方法，实现自定义排序  此时Student类也实现了Comparable接口，重写compareTo()方法  默认优先使用compareTo()方法即实现类的比较器
        TreeSet<Student> treeSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        // TreeSet默认排序，对于对象无法直接排序，此时必须让类继承Comparable接口，重写compareTo()方法，才能添加到TreeSet中，而不是先添加再去使用匿名内部类comparator比较器
        treeSet.add(student1);
        treeSet.add(student2);
        treeSet.add(student3);

        Student student4 = new Student("刘备", 45);
        Student student5 = new Student("诸葛", 66);
        Student student6 = new Student("司马", 99);
        treeSet.add(student4);
        treeSet.add(student5);
        treeSet.add(student6);

        treeSet.forEach(student -> System.out.println(student));

        // 对于Collection集合的并发修改异常问题：使用迭代器Iterator的remove()方法删除元素可以避免

    }
}
