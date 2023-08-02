package com.daily.finalExam.Demo02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 某个学校举行校园运动会，共有10个运动项目供学生报名参加，
 * 分别是：“100米赛跑” , "跳远"，“篮球”，“游泳”，“足球”，“乒乓球”，“铅球”，“射箭”，“自行车”，“跳水”。本次运动会每个学生最多报名参加3个项目。
 * 现在有如下5名学生报名参加了如下运动项目，本数据在**素材 -> select.txt**文件中
 * 张三  100米赛跑,跳远,篮球
 * 李四  游泳,足球,乒乓球
 * 麻子  乒乓球
 * 王五  篮球,跳水,射箭
 * 赵六  篮球,射箭,自行车
 * 刘七  跳水,射箭
 * **具体的功能点如下：**
 * 1、请使用IO流将上述数据读取到程序中来进行处理。
 * 2、请统计出每个运动项目有多少人报名参加。
 * 3、请使用Stream流找出报名人数最多的项目名称。
 * 4、请使用stream流找出哪些人没有选择报名最多的项目，输出他们的名字。
 */
public class Test02 {
    public static void main(String[] args) throws Exception {
        // 1、请使用IO流将上述数据读取到程序中来进行处理。

        // 加载文件
        File file = new File("src\\Demo02\\select.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> list = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }
        System.out.println("1、文件加载详情：");
        list.forEach(System.out::println);
        System.out.println();

        // 封装到学生对象中
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split("  ");
            Student student = new Student(split[0], split[1].split(","));
            students.add(student);
        }

        // 2、请统计出每个运动项目有多少人报名参加。
        System.out.println("2、每个运动项目报名人数统计：");
        ArrayList<String> itemList = new ArrayList<>();
        for (Student student : students) {
            String[] items = student.getItems();
            for (String item : items) {
                itemList.add(item);
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String item : itemList) {
            if (map.containsKey(item)) {
                Integer count = map.get(item);
                map.put(item, ++count);
            } else {
                map.put(item, 1);
            }
        }
        map.forEach((k, v) -> System.out.println(k + "：" + v + "人"));
        System.out.println();

        // 3、请使用Stream流找出报名人数最多的项目名称。
        System.out.println("3、报名人数最多的项目名称：");
        Integer max = map.values().stream().max(Integer::compareTo).get();
        map.forEach((k, v) -> {
            if (v.equals(max)) {
                System.out.println(k);
            }
        });
        System.out.println();

        // 4、请使用stream流找出哪些人没有选择报名最多的项目，输出他们的名字。
        System.out.println("4、以下的同学没有选择报名人数最多的项目：");
        students.stream().filter(student -> {
            String[] items = student.getItems();
            for (String item : items) {
                if (map.get(item).equals(max)) {
                    return false;
                }
            }
            return true;
        }).forEach(student -> System.out.println(student.getName()));

    }
}
