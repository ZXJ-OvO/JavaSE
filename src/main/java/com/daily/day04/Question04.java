package com.daily.day04;

/**
 * 题目四: 各只股票的收益分别是10.4%,-3%,-6.2%,1.2%,-6.1%,-19%,-3.8%,0.9%,-4.5%,5.5%。统计赚钱的股票和赔钱的股票分别有多少只？打印效果如下：
 * 赚钱的股票一共有：4只
 * 赔钱的股票一共有：6只
 */
public class Question04 {
    public static void main(String[] args) {
        double[] stock = {10.4, -3, -6.2, 1.2, -6.1, -19, -3.8, 0.9, -4.5, 5.5};
        int earn = 0;
        int lose = 0;
        for (double i : stock) {
            if (i > 0) {
                earn++;
            } else {
                lose++;
            }
        }
        System.out.println("赚钱的股票一共有：" + earn + "只");
        System.out.println("赔钱的股票一共有：" + lose + "只");
    }
}
