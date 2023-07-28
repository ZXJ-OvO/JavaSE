package com.zxj.day15;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList底层基于数组：根据索引查询速度极快，删除引起元素位移导致效率低，添加导致数组扩容与元素位移使得效率极低
 */
public class Question03 {
    public static void main(String[] args) {
        ArrayList<String> lists = new ArrayList<>();
        lists.add("张三");
        lists.add("李四");
        lists.add("王五");
        lists.add("赵六");
        // 使用子类的特有方法，因此无法使用多态
        lists.add(2, "田七");
        lists.remove(3);
        lists.set(3, "周八");
        lists.get(0);
        System.out.println(lists);

        // for循环遍历
        for (String string : lists) {
            System.out.print(string + "\t");
        }

        System.out.println();

        // 增强for循环遍历
        for (String list : lists) {
            System.out.print(list + "\t");
        }

        System.out.println();
        // 迭代器遍历
        for (String list : lists) {
            System.out.print(list + "\t");
        }

        System.out.println();
        // Lambda表达式遍历
        lists.forEach(s -> System.out.print(s + "\t"));
    }
}
