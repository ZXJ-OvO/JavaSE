package com.zxj.day13;

import cn.hutool.core.date.DateTime;

import java.util.Scanner;

/**
 * 1. 已知日期字符串:"2015-10-20",将该日期字符串转换为日期对象；
 * 2. 将(1)中的日期对象转换为日历类的对象；
 * 3. 根据日期对象获取该日期是星期几,以及这一年的第几天
 * 4. 通过键盘录入日期字符串，格式(2015-10-20)
 */
public class Question19 {
    public static void main(String[] args) {
        String year = new Scanner(System.in).nextLine();
        String month = new Scanner(System.in).nextLine();
        String day = new Scanner(System.in).nextLine();
        DateTime dateTime = new DateTime(year + "-" + month + "-" + day, "yyyy-MM-dd");
        System.out.println("一年的第" + dateTime.dayOfYear() + "天");
        System.out.println("星期" + dateTime.dayOfWeekEnum());
    }
}
