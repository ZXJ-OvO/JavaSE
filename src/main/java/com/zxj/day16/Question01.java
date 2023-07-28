package com.zxj.day16;


public class Question01 {
    public static void main(String[] args) {
        test(1, 2, 3, 4, 5);
    }

    public static void test(int... num) {
        int sum = 0;
        for (int j : num) {
            sum += j;
        }
        System.out.println(sum);
    }
}
