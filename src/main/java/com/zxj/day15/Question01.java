package com.zxj.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class Question01 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Spring");
        list.add("Redis");
        list.clear();
        list.add("Java");
        list.add("Spring");
        list.add("Redis");

        list.remove("Redis");
        System.out.println(list);

        boolean java = list.contains("Java");
        System.out.println(java);

        boolean empty = list.isEmpty();
        System.out.println(empty);

        int size = list.size();
        System.out.println(size);

        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));

        // 迭代器遍历集合
        for (String string : list) {
            System.out.println(string);
        }

        // 增强for循环遍历集合
        for (String name : list) {
            System.out.println(name);
        }

        //Lambda表达式（forEach）遍历集合
        list.forEach(new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        list.forEach(s -> System.out.println(s));

    }
}
