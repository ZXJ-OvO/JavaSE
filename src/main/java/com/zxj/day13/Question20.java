package com.zxj.day13;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.Week;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 上三休一，经常不确定休息日是否是周末。
 * 输入年月，以日历方式显示对应月份的休息日，非休息日空格填充
 * 同时，统计出本月有几天休息，轮到周末休息有几天。（注：首次休息日是2020年2月1日）
 * 1.找到该月份的最大天数
 * 2.计算输入月份月末-首次休息日的间隔天数
 * 3.计算间隔天数中的休息日并放入集合中
 * 4.在间隔天的休息日中找到该查询月份的休息日并放入集合中
 * 5.计算该月休息日的天数
 */
public class Question20 {
    public static void main(String[] args) {
        DateTime theFirstFreeDay = new DateTime("2020年2月1日", "yyyy年MM月dd日");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scanner.nextInt();
        System.out.println("请输入月份：");
        int month = scanner.nextInt();

        DateTime inputDate = new DateTime(year + "年" + month + "月1日", "yyyy年MM月dd日");
        // 打印日历
        printCalendar(inputDate, theFirstFreeDay);

    }


    private static void printCalendar(DateTime inputDate, DateTime theFirstFreeDay) {
        // 间隔天数
        int between = (int) inputDate.between(theFirstFreeDay, DateUnit.DAY);
        System.out.println("间隔天数：" + between);

        // 存放假期的集合
        ArrayList<String> freeDays = new ArrayList<>();

        // 第一次休假的星期数 dayOfWeek从星期日
        Week week = theFirstFreeDay.dayOfWeekEnum();
        int dayOfWeek = theFirstFreeDay.dayOfWeek();
        System.out.println("第一次休假是" + week.toChinese());
        int value = week.getValue();
        System.out.println(value);

        // 打印星期值
        printWeek();

        for (int i = 0; i < between; i++) {

            // 逢七换行
            if (i % 7 == 0) System.out.println();

            if (i < dayOfWeek) {
                if (i == (value - 1 - 1)) {
                    System.out.print("1\t");
                } else {
                    System.out.print("_\t");
                }
            } else {
                if (i % 3 == 0) {
                    DateTime offset = theFirstFreeDay.offset(DateField.DAY_OF_YEAR, 4);
                    freeDays.add(offset.toDateStr());
                    int field = offset.getField(DateField.DAY_OF_MONTH);
                    System.out.print(field + "\t");
                    if (offset.isLastDayOfMonth()) {
                        System.out.println("\n");
                    }
                } else {
                    System.out.print("_\t");
                }
            }
        }

        System.out.println();

        System.out.println(freeDays);
    }

    private static void printWeek() {
        System.out.println();
        System.out.println("一\t二\t三\t四\t五\t六\t日");
    }
}
