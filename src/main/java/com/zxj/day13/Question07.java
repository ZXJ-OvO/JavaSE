package com.zxj.day13;

import java.util.Calendar;
import java.util.Date;

/**
 * API Calendar
 */
public class Question07 {
    public static void main(String[] args) {
        // 抽象类，不能实例化 Calendar类的实例化对象通过getInstance()方法获取
        Calendar calendar = Calendar.getInstance();

        // 通过Calendar类的实例化对象获取年月日时分秒
        System.out.println("年：" + calendar.get(Calendar.YEAR));
        // 月份从0开始，所以要加1
        System.out.println("月：" + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("日：" + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("时：" + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("分：" + calendar.get(Calendar.MINUTE));
        System.out.println("秒：" + calendar.get(Calendar.SECOND));

        // 获取日期对象
        Date time = calendar.getTime();
        System.out.println(time);

        // 获取当前时间的毫秒值
        long timeInMillis = calendar.getTimeInMillis();
        System.out.println(timeInMillis);

        // 设置年月日时分秒
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        // 为某个字段增加或减少值
        calendar.add(Calendar.YEAR, 1);
        calendar.add(Calendar.MONTH, -1);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.HOUR_OF_DAY, -1);
        calendar.add(Calendar.MINUTE, 1);
        calendar.add(Calendar.SECOND, -1);
        System.out.println(calendar.getTime());


    }
}
