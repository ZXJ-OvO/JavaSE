package com.hutool.date;

import cn.hutool.core.date.*;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * cn.hutool.core.date.Date  日期核心API
 */
public class HutoolDateTime {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("-------------------------------------------- 静态方法\n");

        System.out.println("时间戳转换为DateTime：\t" + DateTime.of(System.currentTimeMillis()));
        System.out.println("JDK Date转换为DateTime：\t" + DateTime.of(new java.util.Date()));
        System.out.println("Calendar转换为DateTime：\t" + DateTime.of(Calendar.getInstance()));
        System.out.println("String转换为DateTime：\t" + DateTime.of("2023年6月4日 19时12分16秒", "yyyy年MM月dd日 HH时mm分ss秒"));
        System.out.println("DateTime获取当前时间：\t" + DateTime.now());


        System.out.println("-------------------------------------------- 日期偏移\n");

        DateTime dateTime = DateTime.of("2023年1月1日 00时00分00秒", "yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println("初始时间：\t" + dateTime);
        // 如果此对象为可变对象，返回自身，否则返回新对象
        System.out.println("年 左偏移：\t" + dateTime.offset(DateField.YEAR, -1));
        System.out.println("月 右偏移：\t" + dateTime.offset(DateField.MONTH, 1));
        System.out.println("日 左偏移：\t" + dateTime.offset(DateField.DAY_OF_MONTH, -1));
        System.out.println("时 右偏移：\t" + dateTime.offset(DateField.HOUR, 1));
        System.out.println("分 左偏移：\t" + dateTime.offset(DateField.MINUTE, -1));
        System.out.println("秒 右偏移：\t" + dateTime.offset(DateField.SECOND, 1));

        // 返回调整后的新DateTime，不影响原对象
        DateTime dateTime1 = new DateTime();
        System.out.println(dateTime1);
        System.out.println("不影响原对象的前提下进行偏移：\t" + dateTime1.offsetNew(DateField.YEAR, -1));
        System.out.println(dateTime1);


        System.out.println("-------------------------------------------- 获取日期\n");

        // 通过getField获取时间的某个部分
        DateTime dateTime2 = new DateTime();
        System.out.println("获取年：\t" + dateTime2.getField(DateField.YEAR));
        System.out.println("获取日：\t" + dateTime2.getField(Calendar.DATE));

        // 通过setField给时间的某个部分设置时间
        System.out.println("设置年：\t" + dateTime2.setField(DateField.YEAR, 1));
        System.out.println("设置年：\t" + dateTime2.setField(Calendar.YEAR, 2023));


        System.out.println("获取当前日期的年：\t" + dateTime2.year());
        System.out.println("获取季度（从1计数）：\t" + dateTime2.quarter());
        System.out.println("获取季度（返回枚举）：\t" + dateTime2.quarterEnum());
        System.out.println("获取月份（从0开始计数）：\t" + dateTime2.month());
        System.out.println("获取月份（从1开始计数）：\t" + dateTime2.monthBaseOne());
        System.out.println("获取月份：\t" + dateTime2.monthEnum());
        System.out.println("获取星期：\t" + dateTime2.dayOfWeekEnum());
        System.out.println("获取日：\t" + dateTime2.dayOfMonth());
        System.out.println("获取时（指定24小时制）：\t" + dateTime2.hour(true));
        System.out.println("获取分：\t" + dateTime2.minute());
        System.out.println("获取秒：\t" + dateTime2.second());
        System.out.println("获取毫秒：\t" + dateTime2.millisecond());

        System.out.println("获取一周的第一天，默认为周一：\t" + dateTime2.getFirstDayOfWeek());
        System.out.println("设置一周的第一天，JDK的Calendar默认为周日：\t" + dateTime2.setFirstDayOfWeek(Week.MONDAY));

        System.out.println("设置第一周最少天数：\t" + dateTime2.setMinimalDaysInFirstWeek(7));


        System.out.println("获取时区：\t" + dateTime2.getTimeZone());
        System.out.println("获取时区ID：\t" + dateTime2.getZoneId());
        System.out.println("设置时区：\t" + dateTime2.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo")));

        System.out.println("获取这个月的最后一天：\t" + dateTime2.getLastDayOfMonth());


        System.out.println("-------------------------------------------- 日期判断\n");

        DateTime dateTime3 = new DateTime();
        System.out.println("是否为上午：\t" + dateTime3.isAM());
        System.out.println("是否为下午：\t" + dateTime3.isPM());
        System.out.println("是否为周末 ：\t" + dateTime3.isWeekend());
        System.out.println("是否为闰年 ：\t" + dateTime3.isLeapYear());


        System.out.println("-------------------------------------------- 类型转换\n");

        DateTime dateTime4 = new DateTime();
        System.out.println("DateTime转换为Calendar：\t" + dateTime4.toCalendar());
        System.out.println("DateTime转换为Date：\t" + dateTime4.toJdkDate());
        System.out.println("DateTime转换为LocalDateTime：\t" + dateTime4.toLocalDateTime());
        System.out.println("DateTime转换为Timestamp：\t" + dateTime4.toTimestamp());
        System.out.println("DateTime转换为SqlDate：\t" + dateTime4.toSqlDate());

        System.out.println("转换为字符串（如果指定了时区则按照时区当地的时间进行转换）：\t" + dateTime4.toString());
        System.out.println("转换为字符串（如果指定了时区则按照时区当地的时间进行转换）：\t" + dateTime4.toString(TimeZone.getTimeZone("Asia/Tokyo")));
        System.out.println("转为yyyy-MM-dd HH:mm:ss格式字符串，时区使用当前地区的默认时区：\t" + dateTime4.toStringDefaultTimeZone());
        System.out.println("转为yyyy-MM-dd格式字符串：\t" + dateTime2.toDateStr());
        System.out.println("转为HH:mm:ss格式字符串：\t" + dateTime2.toTimeStr());
        System.out.println("输出精确到毫秒值的字符串：\t" + dateTime2.toMsStr());
        System.out.println("转为指定String格式的字符串：\t" + dateTime2.toString("yyyy:MM:dd HH:mm:ss"));
        // System.out.println("转为指定DatePrinter格式的字符串：\t" + dateTime2.toString(DatePrinter format));
        // System.out.println("转为指定Dateformat格式的字符串：\t" + dateTime2.toString(DateFormat format));


        System.out.println("-------------------------------------------- 日期判断\n");
        DateTime dateTime5 = new DateTime();
        DateTime dateTime6 = DateTime.of("2000年12月16日 00时00分00秒", "yyyy年MM月dd日 HH时mm分ss秒");
        DateTime dateTime7 = DateTime.of("2023年12月16日 00时00分00秒", "yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println("按照默认时间格式计算两个时间的间隔：\t" + dateTime5.between(dateTime6));
        System.out.println("按照指定的时间单位计算两个时间的间隔：\t" + dateTime5.between(dateTime6, DateUnit.WEEK));
        System.out.println("当前日期是否在给定的日期范围内：\t" + dateTime5.isIn(dateTime6, dateTime7));
        System.out.println("当前日期是否在给定的日期之前：\t" + dateTime5.isBefore(dateTime6));
        System.out.println("当前日期是否在给定的日期之前（包括给定的边界值）：\t" + dateTime5.isBeforeOrEquals(dateTime6));
        System.out.println("当前日期是否在给定的日期之后：\t" + dateTime5.isAfter(dateTime6));
        System.out.println("当前日期是否在给定的日期之后包括给定的边界值）：\t" + dateTime5.isAfterOrEquals(dateTime6));

        System.out.println("判断是否为可变对象：\t" + dateTime5.isMutable());
        System.out.println("设置对象是否为可变对象：\t" + dateTime5.setMutable(true));

        System.out.println("是否为本月的最后一天：\t" + dateTime5.isLastDayOfMonth());
        System.out.println("获得本月的最后一天：\t" + dateTime2.getLastDayOfMonth());


        System.out.println("当前时间的时间戳：\t" + DateUtil.current());
        System.out.println("获取指定年数的总天数：\t" + DateUtil.lengthOfYear(2023));

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("                            ChineseDate");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        // 通过农历构建
        ChineseDate chineseDateLunar = new ChineseDate(1989, 6, 4);

        // 通过公历构建
        ChineseDate date = new ChineseDate(DateUtil.parseDate("1989-6-4"));
        System.out.println(chineseDateLunar);
        System.out.println(date);

        // 提供了天干地支、生肖等各种api


        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("                            LocalDateTimeUtil");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        //LocalDateTimeUtil
    }
}
