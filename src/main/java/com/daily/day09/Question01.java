package com.daily.day09;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 第一题:
 * 1. 设计一个Movie类，私有成员变量：title(片名)，director(导演),type(类型)，并生成相应的get/set方法
 * 2. 定义测试类，在main方法中完成以下要求：
 * 2.1创建三个Movie对象，分别为：
 * "唐山大地震"，"冯小刚","灾难";
 * "羞羞的铁拳"，"宋阳","喜剧";
 * "集结号"，"冯小刚","历史";
 * 2.2将以上3个对象添加到list集合中
 * 2.3遍历集合，将导演为"冯小刚"的电影按照如下格式打印到控制台上。
 * 唐山大地震-冯小刚-灾难
 * 集结号-冯小刚-历史
 */
public class Question01 {
    public static void main(String[] args) {
        @NoArgsConstructor
        @Data
        @AllArgsConstructor
        class Movie {
            private String title;
            private String director;
            private String type;
        }

        Movie movie1 = new Movie("唐山大地震", "冯小刚", "灾难");
        Movie movie2 = new Movie("羞羞的铁拳", "宋阳", "喜剧");
        Movie movie3 = new Movie("集结号", "冯小刚", "历史");
        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        for (Movie movie : movies) {
            if (movie.getDirector().equals("冯小刚")) {
                System.out.println(movie.getTitle() + "-" + movie.getDirector() + "-" + movie.getType());
            }
        }
    }
}
