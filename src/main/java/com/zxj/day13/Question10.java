package com.zxj.day13;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;

/**
 * 如图所示:当我们输入年份的时候,会自动计算2月份的天数,以及自动判断是否为闰年,一年有多少天,设计程序,实现此功能!
 */
public class Question10 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now(ZoneId.systemDefault());
        System.out.println("请输入年份：");
        LocalDate time = localDate.withYear(new Scanner(System.in).nextInt());
        // 什么叫闰年 能被4整除但不能被100整除 或者 能被400整除  闰年有那些
        if (time.getYear() % 4 == 0 && time.getYear() % 100 != 0) {
            System.out.println("闰年");
        } else {
            System.out.println("平年");
        }

        System.out.println("一年有" + time.lengthOfYear() + "天");

        System.out.println("二月有" + time.withMonth(2).lengthOfMonth() + "天");


    }
}
