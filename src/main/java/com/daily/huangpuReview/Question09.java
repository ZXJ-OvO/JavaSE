package com.daily.huangpuReview;

import java.util.Random;
import java.util.Scanner;

/**
 * 需求：程序自动生成一个1-100之间的随机数字，使用程序实现猜出这个数字是多少？
 */
public class Question09 {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        int step = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            step++;
            int inputNumber = scanner.nextInt();
            if (inputNumber > randomNumber) {
                System.out.println("输入的太大");
            } else if (inputNumber < randomNumber) {
                System.out.println("输入的太小");
            } else if (inputNumber == randomNumber) {
                System.out.println("猜对了" + "耗费" + step + "步");
                break;
            }
        }
    }
}
