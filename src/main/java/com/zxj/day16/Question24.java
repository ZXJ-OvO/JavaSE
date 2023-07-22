package com.zxj.day16;

import cn.hutool.core.util.RandomUtil;

import java.util.HashSet;

public class Question24 {
    public static void main(String[] args) {
        HashSet<Integer> red = new HashSet<>();

        while (red.size() < 7) {
            int i = RandomUtil.randomInt(1, 34);
            red.add(i);
        }

        int blue = RandomUtil.randomInt(1, 17);

        System.out.print("red：");
        for (Integer integer : red) {
            System.out.print(integer + " ");
        }
        System.out.println("blue：" + blue);
    }
}
