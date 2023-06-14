package com.zxj.day06;

/**
 * 在唱歌比赛中，可能有多名评委要给选手打分，分数是[0 - 100]之间的整数。
 * 选手最后得分为：去掉最高分、最低分后剩余分数的平均分，
 * 请编写程序能够录入多名评委的分数，并算出选手的最终得分。
 */
public class Question03 {
    public static void main(String[] args) {
        int[] score = {99, 88, 77, 66, 55};
        int max = score[0];
        int min = score[0];
        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] > max) {
                max = score[i];
            }
            if (score[i] < min) {
                min = score[i];
            }
            sum += score[i];
        }
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("平均分：" + (sum - max - min) / (score.length - 2));
    }
}
