package com.zxj.day17;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Stream;

public class Question04 {
    public static void main(String[] args) {
        ArrayList<String> list = CollUtil.newArrayList("张无忌", "周芷若", "赵敏", "张强", "张三丰");

        list.stream().filter(name -> name.startsWith("张") && name.length() == 3).forEach(name -> System.out.println(name));

        // 获取集合stream
        Stream<String> stream = list.stream();
        System.out.println("------------------------------------------------");

        // 获取Map集合的Stream流的三种方式
        HashMap<String, Integer> map = new HashMap<>();

        // 1、获取键流
        Stream<String> keyS = map.keySet().stream();

        // 2、获取值流
        Stream<Integer> values = map.values().stream();

        // 3、获取键值对流
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();
        System.out.println("------------------------------------------------");

        // 获取数组的Stream
        String[] names = {"赵敏", "王菲", "小昭"};
        Stream<String> stream1 = Arrays.stream(names);
        Stream<String> stream2 = Stream.of(names);
        Stream<String> stream3 = Stream.of("张无忌", "周芷若", "赵敏", "张强", "张三丰");


        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张无忌", "周芷若", "赵敏", "张强", "张三丰");

        System.out.println("------------------------------------------------");

        // 1、过滤方法
        list1.stream().filter(name -> name.startsWith("张") && name.length() == 3).forEach(System.out::println);

        System.out.println("------------------------------------------------");

        // 准备一个集合、排序
        List<Movie1> movies = new ArrayList<>();
        movies.add(new Movie1("摔跤吧，爸爸", 9.5, "阿米尔汗"));
        movies.add(new Movie1("三傻宝莱坞1", 8.5, "阿米尔汗2"));
        movies.add(new Movie1("三傻宝莱坞2", 8.6, "阿米尔汗2"));
        movies.add(new Movie1("三傻宝莱坞4", 8.8, "阿米尔汗2"));
        movies.add(new Movie1("三傻宝莱坞4", 8.8, "阿米尔汗2"));
        movies.add(new Movie1("阿甘正传", 7.5, "汤姆汉克斯"));

        System.out.println("------------------------------------------------");

        // 集合中如果存储的对象
        // 方式一：对象类可以实现Comparable接口，指定比较规则 sorted方法就可以按照规则进行排序，否则报错！
        movies.stream().sorted().forEach(System.out::println);

        movies.stream().sorted((movie1, movie2) -> Double.compare(movie2.getScore(), movie1.getScore()));

        // limit取前几个
        System.out.println("------------------------------------------------");
        movies.stream().sorted((movie1, movie2) -> Double.compare(movie1.getScore(), movie2.getScore())).limit(2).forEach(System.out::println);


        System.out.println("------------------------------------------------");
        // skip 跳过前几个
        movies.stream().sorted((o1, o2) -> Double.compare(o2.getScore(), o1.getScore())).skip(3).forEach(System.out::println);

        // distinct去重复
        System.out.println("------------------------------------------------");
        movies.stream().distinct().forEach(System.out::println);

        // map加工方法（映射）：把流上的数据加工成新数据，注意此时可以操作源数据但是本质上stream流不会改变源数据
        System.out.println("--------------------------------------------------");
        movies.stream().peek(m -> m.setName("豆瓣：" + m.getName())).forEach(System.out::println);

        movies.forEach(m -> System.out.println(m));

        // 合并流
        Stream<String> s1 = Stream.of("张三", "李四", "王五");
        Stream<String> s2 = Stream.of("关羽", "赵云", "张飞");
        Stream<String> allStream = Stream.concat(s1, s2);
        allStream.map(s -> "黑马：" + s).forEach(System.out::println);
        // allStream.count() 流只能操作一次

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Movie1 implements Comparable<Movie1> {
    private String name;
    private double score;
    private String actor;

    @Override
    public int compareTo(Movie1 o) {
        return Double.compare(this.getScore(), o.getScore());
    }
}