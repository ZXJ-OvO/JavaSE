package com.zxj.day04;

import java.util.Scanner;

/**
 * 某歌唱比赛，需要开发一个系统：可以录入6名评委的打分，录入完毕后立即输出平均分做为选手得分。
 */
public class Question02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] array = new double[6];
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print("请输入第" + (i + 1) + "位评委的打分：");
            array[i] = in.nextDouble();
            sum += array[i];
        }
        System.out.println("选手的得分是：" + sum / array.length);
    }
}
