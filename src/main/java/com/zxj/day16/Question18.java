package com.zxj.day16;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Question18 {
    public static void main(String[] args) {
        HashSet<Integer> red = CollUtil.newHashSet();
        while (red.size() < 7) {
            int i = RandomUtil.randomInt(1, 34);
            red.add(i);
        }

        ArrayList<Integer> list = CollUtil.newArrayList(RandomUtil.randomInt(1, 17));

        list.addAll(red);
        Collections.reverse(list);
        System.out.print("红球：");
        for (int i = 0; i < 6; i++) {
            System.out.print(list.get(i) + "  ");
        }
        System.out.println(" 蓝球：" + list.get(6));

    }
}
