package com.zxj.day05;

import java.util.*;

/**
 * 一个大V直播抽奖，奖品是现金红包，
 * 分别有{2,588,888,1000,10000}五个奖金。
 * 请使用代码模拟抽奖，打印出每个奖项，
 * 奖项的出现顺序要随机且不重复。
 */
public class Question14 {
    public static void main(String[] args) {
        bonus();
    }

    public static void bonus(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(588);
        list.add(888);
        list.add(1000);
        list.add(10000);
        Collections.shuffle(list);
        int i = 1;
        for (Integer integer : list) {
            System.out.printf("%-2d：%5d\t\t", i++, integer);
        }
        System.out.println();
    }
}
