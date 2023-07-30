package com.zxj.day06;

import java.util.Scanner;

/**
 * 编写一个方法，判断用户的彩票号码是否中奖，具体中奖规则如下
 * - 6红 + 1蓝  1000万
 * - 6红 + 0蓝  500万
 * - 5红 + 1蓝  3000块
 * - 5红 + 0蓝 或者 4红 + 1蓝 200块
 * - 4红 + 0蓝 或者 3红 + 1蓝 10块
 * - 2、1、0红 + 1蓝 5块
 * - 其余未中奖
 * 编写一个方法，让用户自动机选投注，产生一注双色球彩票
 * 编写一个方法，让用户手动投注，产生一注双色球彩票，思路分析
 * 6红1蓝     红1-33  蓝1-16
 */

public class Question09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        expectNum(scanner);
    }

    /**
     * 用户投注
     */
    public static void expectNum(Scanner scanner) {
        int[] redBalls = new int[6];
        int blueBall = 0;

        System.out.println("请按提示输入彩票号码：");
        // 输入红球号码
        for (int i = 0; i < 6; i++) {
            boolean isValid = false;
            while (!isValid) {
                System.out.print("请输入第 " + (i + 1) + " 个红球号码 (1-33)：");
                int num = scanner.nextInt();
                if (num >= 1 && num <= 33) {
                    redBalls[i] = num;
                    isValid = true;
                } else {
                    System.out.println("输入错误，请重新输入！");
                }
            }
        }

        // 输入蓝色球号码
        boolean isValid = false;
        while (!isValid) {
            System.out.print("请输入蓝球号码 (1-16)：");
            int num = scanner.nextInt();
            if (num >= 1 && num <= 16) {
                blueBall = num;
                isValid = true;
            } else {
                System.out.println("输入错误，请重新输入！");
            }
        }

        // 打印生成的彩票号码
        System.out.print("您的彩票号码是：");
        for (int i = 0; i < 6; i++) {
            System.out.print(redBalls[i] + " ");
        }
        System.out.println("蓝球：" + blueBall);

        // 校验彩票号码是否中奖
        checkNum(redBalls, blueBall);
    }

    /**
     * 生成红球号码
     */
    public static int[] generateRedBalls() {
        int[] redBalls = new int[6];
        for (int i = 0; i < 6; i++) {
            redBalls[i] = (int) (Math.random() * 33) + 1;
        }
        return redBalls;
    }

    /**
     * 生成蓝色球号码
     */
    public static int generateBlueBall() {
        return (int) (Math.random() * 16) + 1;
    }

    /**
     * 校验彩票号码是否中奖
     */
    public static void checkNum(int[] redBalls, int blueBall) {
        // 开奖号码
        int[] luckyRedBalls = generateRedBalls();
        int luckyBlueBall = generateBlueBall();

        // 打印开奖号码
        System.out.print("开奖号码是：");
        for (int i = 0; i < 6; i++) {
            System.out.print(luckyRedBalls[i] + " ");
        }
        System.out.println("蓝球：" + luckyBlueBall);

        // 比较红球号码中的相同数量
        int countRed = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (redBalls[i] == luckyRedBalls[j]) {
                    countRed++;
                    break;
                }
            }
        }

        // 比较蓝色球号码是否相同
        boolean isBlueMatch = (blueBall == luckyBlueBall);

        // 判断中奖等级
        if (countRed == 6 && isBlueMatch) {
            System.out.println("恭喜您中得一等奖，奖金1000万！");
        } else if (countRed == 6) {
            System.out.println("恭喜您中得二等奖，奖金500万！");
        } else if (countRed == 5 && isBlueMatch) {
            System.out.println("恭喜您中得三等奖，奖金3000块！");
        } else if (countRed == 5 || (countRed == 4 && isBlueMatch)) {
            System.out.println("恭喜您中得四等奖，奖金200块！");
        } else if (countRed == 4 || (countRed == 3 && isBlueMatch)) {
            System.out.println("恭喜您中得五等奖，奖金10块！");
        } else if (countRed == 2 || countRed == 1 || countRed == 0) {
            System.out.println("恭喜您中得六等奖，奖金5块！");
        } else {
            System.out.println("很遗憾，您未中奖！");
        }
    }
}
