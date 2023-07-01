package com.zxj.day17;

import java.util.HashMap;

/**
 * 某学校Java学科分为基础班和就业班:
 * Java基础班:
 * 001	李晨
 * 002	范冰冰
 * Java就业班:
 * 001	马云
 * 002	马化腾
 * 使用HashMap嵌套HashMap方式完成存储数据,并遍历出所有的学生
 */
public class Question02 {
    public static void main(String[] args) {
        // Java基础班
        HashMap<String, String> base = new HashMap<>();
        // Java就业班
        HashMap<String, String> better = new HashMap<>();
        // Java学科
        HashMap<String, HashMap<String, String>> itcast = new HashMap<>();

        base.put("001", "李晨");
        base.put("002", "范冰冰");
        better.put("001", "马云");
        better.put("002", "马化腾");
        itcast.put("Java基础班", base);
        itcast.put("Java就业班", better);
        System.out.println(itcast);
    }
}
