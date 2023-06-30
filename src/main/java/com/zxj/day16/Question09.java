package com.zxj.day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List<String> list = new ArrayList<>();
 * list.add("张无忌");
 * list.add("周芷若";
 * list.add("赵敏";
 * list.add("张强";
 * list.add("张三丰");
 * 把集合中所有以“张”开头，且是3个字的元素存储到一个新的集合。
 */
public class Question09 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        List<String> list1 = list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).collect(Collectors.toList());
        System.out.println(list1);
    }
}
