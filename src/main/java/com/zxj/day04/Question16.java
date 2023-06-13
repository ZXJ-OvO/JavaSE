package com.zxj.day04;

/**
 * 定义一个数组来存储10个学生的成绩，例如：
 * {72, 89, 65, 87, 91, 82, 71, 93, 76, 68}。
 * 计算并输出学生的平均成绩。
 */
public class Question16 {
    public static void main(String[] args) {
        int[] scores = {72, 89, 65, 87, 91, 82, 71, 93, 76, 68};
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        System.out.println("平均成绩为：" + sum / scores.length);
    }
}
