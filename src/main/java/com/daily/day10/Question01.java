package com.daily.day10;

import java.util.Arrays;

/**
 * 给定一个数组，大小为10，输入十个同学的成绩，求这些成绩的总分数；某一天转入2个新同学，请再次求12个同学的平均成绩（尝试着使用扩容的形式做）
 */
public class Question01 {

    public static void main(String[] args) {
        int[] scoreArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        int sumScore = 0;
        for (int i : scoreArray) {
            sumScore += i;
        }

        System.out.println("十个同学的成绩总分为：" + sumScore);

        int[] newScoreArray = Arrays.copyOf(scoreArray, scoreArray.length + 2);

        System.out.println("当前数组长度为：" + newScoreArray.length);

        newScoreArray[10] = 110;
        newScoreArray[11] = 120;

        System.out.println("十二个同学的成绩总分为：" + Arrays.stream(newScoreArray).sum());
    }
}
