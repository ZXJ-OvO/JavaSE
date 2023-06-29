package com.daily.day05;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 9.写一个方法，对数组中的元素打乱顺序
 */
public class Question09 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        shuffle(arr);
    }

    public static void shuffle(Integer[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>(arr.length);
        Collections.addAll(arrayList, arr);
        Collections.shuffle(arrayList);
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
    }
}
