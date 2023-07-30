package com.zxj.day15;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * 使用所学知识,完成"我的订单"业务需求
 * 我的每个订单中有很多订单项,而订单项都是由商品构成的,我们的账户上有可能有很多个订单,请设计一个程序完成订单,并将订单项中的每一个商品信息打印到控制台上!
 */
public class Question09 {
    public static void main(String[] args) {

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Goods {
            private String name;
            private double price;
        }

        ArrayList<Goods> list = new ArrayList<>();
        list.add(new Goods("电脑", 10000));
        list.add(new Goods("手机", 5000));
        list.add(new Goods("平板", 3000));
        list.add(new Goods("耳机", 1000));
        // list.forEach(System.out::println);
        // 按金额升序排序
/*        list.sort(new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });*/

        list.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));

        // forEach完整写法遍历list
        list.forEach(System.out::println);

        list.forEach(System.out::println);

        list.forEach(System.out::println);

    }
}
