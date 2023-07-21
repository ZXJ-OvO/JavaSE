package com.zxj.day15;


import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

public class Question11 {
    public static void main(String[] args) {
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Movies {
            private String name;
            private Double price;
            private Boolean isLive;
        }

        Collection<Movies> movies = CollUtil.newArrayList(new Movies("星际穿越", 100.0, true),
                new Movies("钢琴家", 120.0, true),
                new Movies("大话西游", 80.0, false));

        Collection<Movies> price = CollUtil.sortByProperty(movies, "price");

        price.forEach(System.out::println);

    }
}
