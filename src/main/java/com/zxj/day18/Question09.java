package com.zxj.day18;

/**
 * 啤酒2元1瓶，4个盖子可以换一瓶，2个空瓶可以换一瓶，
 * 请问10元钱可以喝多少瓶酒，剩余多少空瓶和盖子。
 */
public class Question09 {
    public static int totalNumber; // 总酒数
    public static int lastBottleNumber; // 剩余瓶子
    public static int lastCoverNumber; // 剩余盖子

    public static void main(String[] args) {
        buy(10);
        System.out.println("总数" + totalNumber);
        System.out.println("剩余盖子" + lastCoverNumber);
        System.out.println("剩余瓶子" + lastBottleNumber);
    }

    public static void buy(int money) {
        // 所有钱拿去买酒
        int buyNumber = money / 2;
        totalNumber += buyNumber;

        // 把盖子和瓶子换算成钱继续买
        // 计算本轮总数的盖子数和瓶子数
        int allBottleNumber = buyNumber + lastBottleNumber;
        int allCoverNumber = buyNumber + lastCoverNumber;

        // 本轮总数的盖子数和瓶子数换算成钱
        int allMoney = 0;

        if (allBottleNumber >= 2) {
            // allBottleNumber可能是奇数，所以要取整了传递而不能直接用allMoney = allBottleNumber
            allMoney += (allBottleNumber / 2) * 2;
        }
        // 本轮剩余瓶子数
        lastBottleNumber = allBottleNumber % 2;

        if (allCoverNumber >= 4) {
            allMoney += (allCoverNumber / 4) * 2;
        }
        lastCoverNumber = allCoverNumber % 4;

        // 本轮换算的钱递归继续买酒
        if (allMoney >= 2) {
            buy(allMoney);
        }
    }
}
