package com.zxj.day18;

/**
 * 方法递归：直接递归，间接递归
 * 方法递归如果没有结束条件，会出现栈内存溢出
 */
public class Question07 {
    public static void main(String[] args) {
        test2();
    }

    // 直接递归
    public static void test() {
        System.out.println("------test------");
        test();
    }

    // 间接递归
    public static void test2() {
        System.out.println("------test2------");
        test3();
    }

    // 间接递归
    public static void test3() {
        System.out.println("------test3------");
        test2();
    }
}
