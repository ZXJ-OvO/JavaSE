package com.zxj.day15;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class Question16 {
    public static void main(String[] args) {
        System.out.println("输入抓阄的内容：");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = CollUtil.newArrayList();
        for (int i = 0; i < 5; i++) {
            String next = scanner.next();
            list.add(next);
        }

        System.out.println("输入参与的人的名称：");
        ArrayList<String> name = CollUtil.newArrayList();
        for (int i = 0; i < 5; i++) {
            String next = scanner.next();
            name.add(next);
        }

        Collections.shuffle(list);
        Collections.shuffle(name);

        Map<String, String> zip = CollUtil.zip(list, name);
        System.out.println(zip);

    }
}
