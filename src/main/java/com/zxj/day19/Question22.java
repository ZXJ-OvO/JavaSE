package com.zxj.day19;

import java.util.ArrayList;
import java.util.Random;

public class Question22 {
    public static void main(String[] args) {
        String[] strings = new String[]{"A", "B", "C", "D"};
        ArrayList<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int j = random.nextInt(3);
            list.add(strings[j]);
        }
        System.out.println("礼物总览：" + list);
    }
}