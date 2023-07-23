package com.daily.huangpuMiddleTest.demo05;

public class Test {
    public static void main(String[] args) {
        // 测试构造器
        MyArrayList<Integer> lists = new MyArrayList<>();

        // 测试add()和forEach()
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.forEach(System.out::print);

        // 测试size()
        System.out.println();
        System.out.println(lists.size());

        // TODO: 2023/7/23 addAll

        // TODO: 2023/7/23 addByIndex

    }
}
