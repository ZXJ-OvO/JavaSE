package com.zxj.day04;

import cn.hutool.core.convert.Convert;

import java.util.Collections;
import java.util.List;

/**
 * 某个数组有5个数据：10,20,30,40,50，请将这个数组中的数据进行反转
 */
public class Question05 {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        List<?> list = Convert.toList(array);
        Collections.reverse(list);

        System.out.println("反转后：");
        list.forEach(System.out::println);
    }
}
