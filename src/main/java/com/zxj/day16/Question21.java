package com.zxj.day16;

import java.util.HashMap;

public class Question21 {
    public static void main(String[] args) {
        HashMap<String, String> base = new HashMap<>();
        HashMap<String, String> better = new HashMap<>();
        HashMap<String, HashMap<String, String>> categories = new HashMap<>();

        base.put("001", "徐磊");
        base.put("002", "蔡英文");
        better.put("001", "陈水扁");
        better.put("002", "李登辉");

        categories.put("Java基础班:", base);
        categories.put("Java就业班:", better);

        categories.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((k1, v1) -> {
                System.out.println("\t" + k1 + " " + v1);
            });
        });

    }
}