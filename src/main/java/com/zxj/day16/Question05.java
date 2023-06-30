package com.zxj.day16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * 需求：创建一个HashMap集合，键是学生对象(Student)，值是籍贯(String)。存储三个键值对元素，并遍历
 * 定义学生类
 * 创建HashMap集合对象
 * 创建学生对象
 * 把学生添加到集合
 * 遍历集合
 */
public class Question05 {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Students {
        private String name;
        private String address;
    }

    public static void main(String[] args) {
        HashMap<Students, String> studentsStringHashMap = new HashMap<>();
        Students students1 = new Students("张三", "北京");
        Students students2 = new Students("李四", "上海");
        Students students3 = new Students("王五", "广州");

        studentsStringHashMap.put(students1, students1.getAddress());
        studentsStringHashMap.put(students2, students2.getAddress());
        studentsStringHashMap.put(students3, students3.getAddress());

        studentsStringHashMap.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
