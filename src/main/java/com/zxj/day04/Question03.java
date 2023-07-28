package com.zxj.day04;

/**
 * 某班级学生的Java考试成绩是：99, 100, 62, 15, 48, 65, 98, 99, 5, 59.5, 75; 请统计及格学生总人数。
 */
public class Question03 {
    public static void main(String[] args) {
        double[] score = {99, 100, 62, 15, 48, 65, 98, 99, 5, 59.5, 75};
        int sum = 0;
        for (double v : score) {
            if (v >= 60) {
                sum++;
            }
        }
        System.out.println("及格人数为：" + sum);
    }
}
