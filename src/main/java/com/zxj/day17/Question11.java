package com.zxj.day17;

public class Question11 {
    public static void main(String[] args) {
        // 目标：认识递归的形式。
        // test1();
        test2();
    }

    private static void test2() {
        test3();
    }

    private static void test3() {
        test2(); // 间接递归：
    }


}
