package com.daily.huangpuMiddleTest.demo06;


public class Test {
    public static void main(String[] args) {
        // 测试构造器
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // 测试add()方法和forEach方法
//        list.add(10.1);
//        list.add(25.2);
//        list.add(3.1);
//        list.add(10.3);
//        list.add(25.1);
//        list.add(35.1);
//        list.add(10.0);
//        list.forEach(System.out::println);
//        System.out.println();

//        // 测试deleteAtIndex()方法
//        list.deleteAtIndex(0);
//        list.forEach(System.out::println);
//        System.out.println();
//
//        // 测试update()方法
//        list.update(1, 2);
//        list.forEach(System.out::println);
//        System.out.println();
//
//        // 测试get()方法
//        System.out.println(list.get(2));
//
//        // 测试size()方法
//        System.out.println(list.size());

        // 测试sort()方法

//        list.add(15);
//        list.add(98);
//        list.add(24);
//        list.add(24);
//        list.add(241);
//        list.add(242);
//        list.add(61);
//        list.add(16);
//        list.add(40);
//        list.sort((o1, o2) -> (o1 - o2));
//        //list.sort((o1, o2) -> (int) (o1 - o2));
//        list.forEach(System.out::println);


//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(4);
//        list.add(5);
//        list.deleteDuplicate();
//        list.forEach(s -> System.out.println(s));

        XL<Double> doubleXL = new XL<>();
        doubleXL.add(1.1);
        doubleXL.add(1.2);
        doubleXL.add(0.7);
        doubleXL.add(0.65);
        doubleXL.add(0.65);
        doubleXL.add(-0.7);
        doubleXL.add(1.3);
        doubleXL.sort();
        doubleXL.forEach();
    }
}
