package com.zxj.day16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Collections
 */
public class Question02 {
    public static void main(String[] args) {
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Goods {
            private String name;
            private double price;
        }

        ArrayList<Goods> goods = new ArrayList<>();
        Collections.addAll(goods, new Goods("电脑", 1999.99), new Goods("鼠标", 10.99), new Goods("键盘", 20.99));

        System.out.println("排序前：");
        goods.forEach(System.out::println);

        System.out.println("打乱后：");
        Collections.shuffle(goods);
        goods.forEach(System.out::println);

        ArrayList<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 10, 2, 30, 4, 50);
        Collections.sort(integers);
        System.out.println("排序后：");
        integers.forEach(System.out::println);

        goods.sort(new Comparator<>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        System.out.println("按价格排序后：");
        goods.forEach(System.out::println);

    }
}
