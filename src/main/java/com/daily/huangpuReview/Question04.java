package com.daily.huangpuReview;

/**
 * 给定一个范围，比如100~1000，统计这个范围内有多少个质数。
 */
public class Question04 {
    public static void main(String[] args) {
        System.out.println(searchData(100, 1000));

    }

    private static int searchData(int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            Boolean number = isPrimeNumber(i);
            if (number) count++;
        }
        return count;
    }

    private static Boolean isPrimeNumber(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
