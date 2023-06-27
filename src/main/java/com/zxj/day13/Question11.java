package com.zxj.day13;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 * 某公司人事举办了这样一个活动,凡是入职6周年的员工,赠送一个精美小礼品,
 * 于是员工纷纷去计算了自己的入职年限,请设计程序,帮同事们计算出入职年限.
 */
public class Question11 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入入职年份");
        int year = scanner.nextInt();
        System.out.println("请输入入职月份");
        int month = scanner.nextInt();
        System.out.println("请输入入职日期");
        int day = scanner.nextInt();
        LocalDate joinTime = LocalDate.of(year, month, day);
        Period between = Period.between(joinTime, localDate);
        int years = between.getYears();
        System.out.println("入职" + years + "年");
    }
}
