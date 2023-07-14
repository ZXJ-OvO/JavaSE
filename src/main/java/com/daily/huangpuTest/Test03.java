package com.daily.huangpuTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 生成5个随机数，打乱数组中元素的顺序。
 * 并将打乱之后的数组遍历打印出来
 * 要求1：
 * 随机数的范围：15~27，包含15，也包含27
 * 要求2：
 * 遍历打印的格式如下：【15, 23, 21, 17, 22】
 */
public class Test03 {
    public static void main(String[] args) {
        int[] ints = new int[5];
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(13) + 15;
        }

        for (int i = 0; i < ints.length; i++) {
            list.add(ints[i]);
        }
        Collections.shuffle(list);
        System.out.println(list);
    }
}
