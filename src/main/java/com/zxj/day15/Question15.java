package com.zxj.day15;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

public class Question15 {
    public static void main(String[] args) {

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Goods {
            private String name;
            private Double price;
            private Integer number;
        }

        ArrayList<Goods> goods = CollUtil.newArrayList(new Goods("华为", 999.9, 2),
                new Goods("苹果", 1100.99, 2),
                new Goods("三星", 970.29, 1));

        ArrayList<Goods> order = CollUtil.newArrayList(goods);

        goods.forEach(System.out::println);

    }
}
