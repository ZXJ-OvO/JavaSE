package com.zxj.day17;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream流常见的终结方法
 */
public class Question05 {
    public static void main(String[] args) {
        List<Movie1> movies = new ArrayList<>();
        movies.add(new Movie1("摔跤吧，爸爸", 9.5, "阿米尔汗"));
        movies.add(new Movie1("三傻宝莱坞", 8.5, "阿米尔汗2"));
        movies.add(new Movie1("三傻宝莱坞", 8.5, "阿米尔汗2"));
        movies.add(new Movie1("阿甘正传", 7.5, "汤姆汉克斯"));

        // 1、forEach
        movies.forEach(System.out::println);

        // 2、count
        System.out.println((long) movies.size());

        // 3、取最大值，前提是必须升序排序
        //noinspection OptionalGetWithoutIsPresent
        Movie1 max = movies.stream().max(Comparator.comparingDouble(Movie1::getScore)).get();
        System.out.println(max);


        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");

        // 4、收集Stream流：把流中的数据恢复到集合或者数组中去。

        // 收集到List集合
        List<String> collect = list.stream().
                filter(s -> s.startsWith("张") && s.length() == 3).
                collect(Collectors.toList());
        collect.add("这样收集流得到的是可变集合");
        System.out.println(collect);


        // 收集到Set集合
        // 流只能用一次
        Set<String> set = list.stream().
                filter(s -> s.startsWith("张") && s.length() == 3).
                collect(Collectors.toSet());
        set.add("这样收集流得到的是可变集合");
        System.out.println(set);

        // 收集到数组
        Stream<String> stream = list.stream().map(s -> s + " ok");
        String[] array = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(array));

        // 拓展
        // 收到到Map集合。
        System.out.println("------------------------------------");
        List<Movie1> movies1 = new ArrayList<>();
        movies1.add(new Movie1("摔跤吧，爸爸", 9.5, "阿米尔汗"));
        movies1.add(new Movie1("三傻宝莱坞", 8.5, "阿米尔汗2"));
        movies1.add(new Movie1("三傻宝莱坞", 8.5, "阿米尔汗2"));
        movies1.add(new Movie1("阿甘正传", 7.5, "汤姆汉克斯"));
        Map<String, Double> result = movies1.stream()
                .filter(m -> m.getScore() > 8.0)
                .distinct()
                .collect(Collectors.toMap(Movie1::getName, Movie1::getScore));
        System.out.println(result);
    }
}
