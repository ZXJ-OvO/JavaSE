package com.zxj.day10;

import java.util.ArrayList;

public class Question01 {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("b");
        list.add("b");
        System.out.println(list);
        // a b c b b
        // <-
        // list删除元素时，会自动向前移动，所以要从后往前遍历

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals("b")) {
                list.remove(i);
            }
        }

        System.out.println(list);
    }
}
