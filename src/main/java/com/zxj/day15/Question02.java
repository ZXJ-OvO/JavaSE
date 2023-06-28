package com.zxj.day15;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 遍历集合中的三个电影对象，输出每部电影的详细信息
 */
public class Question02 {
    public static void main(String[] args) {
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        class Movie {
            private String name;
            private double price;
        }
        Collection<Movie> list = new ArrayList<>();
        Movie movie = new Movie();
        movie.setName("黑铁的鱼影");
        movie.setPrice(99.99);
        Movie movie1 = new Movie();
        movie1.setName("八九六四");
        movie1.setPrice(89.64);
        list.add(movie);
        list.add(movie1);
        Iterator<Movie> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        list.forEach(s -> System.out.println(s));
        for (Movie s : list) {
            System.out.println(s.toString());
        }
    }
}
