package com.daily.day10;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 分析以下需求，并用代码实现
 * 1.定义ArrayList集合，存入多个字符串
 * 如:"ab1" "123ad"  "bca" "dadfadf"  "dddaaa"  "你好啊"  "我来啦"  "别跑啊"
 * 2.遍历集合,删除长度大于5的字符串,打印删除后的集合对象
 * 3.基于上一步,删除集合中元素包含0-9数字的字符串(只要字符串中包含0-9中的任意一个数字就需要删除此整个字符串)
 */
public class Question04 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "ab1", "123ad", "bca", "dadfadf", "dddaaa", "你好啊", "我来啦", "别跑啊");

        ArrayList<String> afterDeleteOutOfLength = new ArrayList<>();
        for (String s : arrayList) {
            if (s.length() > 5) {
                afterDeleteOutOfLength.add(s);
            }
        }
        arrayList.removeAll(afterDeleteOutOfLength);
        System.out.println("删除长度大于5的字符串后原集合剩余的元素是：" + arrayList);

        ArrayList<String> afterDeleteNumber = new ArrayList<>();

        String number = "0123456789";
        for (String s : arrayList) {
            for (int i = 0; i < s.length(); i++) {
                if (number.contains(s.charAt(i) + "")) {
                    afterDeleteNumber.add(s);
                    break;
                }
            }
        }

        arrayList.removeAll(afterDeleteNumber);

        System.out.println("删除元素中包阔数字的字符串之后原集合剩余的元素是：" + arrayList);
    }
}
