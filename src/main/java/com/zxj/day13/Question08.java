package com.zxj.day13;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * API JDK8 Java.time
 */
public class Question08 {
    public static void main(String[] args) {

        System.out.println("-------------------------LocalTime 时分秒、LocalDateTime 年月日时分秒、LocalDate 年月日 代替 Calendar -------------------------");
        // 1.获取当前时间 年月日 星期 时分秒 纳秒
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        // 2.获取指定时间对象LocalDateTime.of(年，月，日，时，分，秒，纳秒)
        LocalDateTime of = LocalDateTime.of(2000, 12, 16, 8, 30, 26, 16);
        System.out.println(of);

        int year = localDateTime.getYear();
        System.out.println("年：" + year);
        int monthValue = localDateTime.getMonthValue();
        System.out.println("月：" + monthValue);
        int dayOfMonth = localDateTime.getDayOfMonth();
        System.out.println("日：" + dayOfMonth);
        int hour = localDateTime.getHour();
        System.out.println("时：" + hour);
        int minute = localDateTime.getMinute();
        System.out.println("分：" + minute);
        int second = localDateTime.getSecond();
        System.out.println("秒：" + second);
        int nano = localDateTime.getNano();
        System.out.println("纳秒：" + nano);
        int dayOfYear = localDateTime.getDayOfYear();
        System.out.println("一年中的第几天：" + dayOfYear);
        // DayOfWeek dayOfWeek = localDateTime.getDayOfWeek(); // Thursday
        int dayOfWeek = localDateTime.getDayOfWeek().getValue(); // Thursday
        System.out.println("一周中的第几天：" + dayOfWeek);

        LocalDateTime localDateTime1 = localDateTime.withYear(2020);
        System.out.println("修改年：" + localDateTime1);
        LocalDateTime localDateTime2 = localDateTime.withMonth(10);
        System.out.println("修改月：" + localDateTime2);
        LocalDateTime localDateTime3 = localDateTime.withDayOfMonth(10);
        System.out.println("修改日：" + localDateTime3);
        LocalDateTime localDateTime4 = localDateTime.withHour(10);
        System.out.println("修改时：" + localDateTime4);
        LocalDateTime localDateTime5 = localDateTime.withMinute(10);
        System.out.println("修改分：" + localDateTime5);
        LocalDateTime localDateTime6 = localDateTime.withSecond(10);
        System.out.println("修改秒：" + localDateTime6);
        LocalDateTime localDateTime7 = localDateTime.withNano(10);
        System.out.println("修改纳秒：" + localDateTime7);


        localDateTime.plusYears(1);
        System.out.println("加一年：" + localDateTime);
        localDateTime.plusMonths(1);
        System.out.println("加一月：" + localDateTime);
        localDateTime.plusDays(1);
        System.out.println("加一日：" + localDateTime);
        localDateTime.plusHours(1);
        System.out.println("加一时：" + localDateTime);
        localDateTime.plusMinutes(1);
        System.out.println("加一分：" + localDateTime);
        localDateTime.plusSeconds(1);
        System.out.println("加一秒：" + localDateTime);
        localDateTime.plusNanos(1);
        System.out.println("加一纳秒：" + localDateTime);


        localDateTime.minusYears(1);
        System.out.println("减一年：" + localDateTime);
        localDateTime.minusMonths(1);
        System.out.println("减一月：" + localDateTime);
        localDateTime.minusDays(1);
        System.out.println("减一日：" + localDateTime);
        localDateTime.minusHours(1);
        System.out.println("减一时：" + localDateTime);
        localDateTime.minusMinutes(1);
        System.out.println("减一分：" + localDateTime);
        localDateTime.minusSeconds(1);
        System.out.println("减一秒：" + localDateTime);
        localDateTime.minusNanos(1);
        System.out.println("减一纳秒：" + localDateTime);

        localDateTime.isAfter(localDateTime1);
        System.out.println("是否在指定时间之后：" + localDateTime.isAfter(localDateTime1));
        localDateTime.isBefore(localDateTime1);
        System.out.println("是否在指定时间之前：" + localDateTime.isBefore(localDateTime1));
        localDateTime.isEqual(localDateTime1);
        System.out.println("是否在指定时间相等：" + localDateTime.isEqual(localDateTime1));


        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println("获取日期：" + localDate);
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println("获取时间：" + localTime);


        // 获取Java中支持的所有的时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("获取Java中支持的所有的时区：" + availableZoneIds);

        // 获取系统默认时区
        ZoneId systemDefault = ZoneId.systemDefault();
        System.out.println("获取系统默认时区：" + systemDefault);

        // 获取当前时区的ZonedDateTime对象
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("获取当前时区的ZonedDateTime对象：" + now);

        // 获取指定时区的ZonedDateTime对象
        ZonedDateTime now1 = ZonedDateTime.now(systemDefault);
        System.out.println("获取指定时区的ZonedDateTime对象：" + now1);

        // 获取年月日时分秒纳秒
        int year1 = now.getYear();
        System.out.println("获取年：" + year1);
        int monthValue1 = now.getMonthValue();
        System.out.println("获取月：" + monthValue1);
        int dayOfMonth1 = now.getDayOfMonth();
        System.out.println("获取日：" + dayOfMonth1);
        int hour1 = now.getHour();
        System.out.println("获取时：" + hour1);
        int minute1 = now.getMinute();
        System.out.println("获取分：" + minute1);
        int second1 = now.getSecond();
        System.out.println("获取秒：" + second1);
        int nano1 = now.getNano();
        System.out.println("获取纳秒：" + nano1);

        System.out.println("-------------------------ZoneId 时区、ZonedDateTime 带时区的时间 代替 Calendar -------------------------");
        // 修改指定时区年月日时分秒纳秒
        ZonedDateTime zonedDateTime = now.withYear(2020);
        System.out.println("修改年：" + zonedDateTime);
        ZonedDateTime zonedDateTime1 = now.withMonth(10);
        System.out.println("修改月：" + zonedDateTime1);
        ZonedDateTime zonedDateTime2 = now.withDayOfMonth(10);
        System.out.println("修改日：" + zonedDateTime2);
        ZonedDateTime zonedDateTime3 = now.withHour(10);
        System.out.println("修改时：" + zonedDateTime3);
        ZonedDateTime zonedDateTime4 = now.withMinute(10);
        System.out.println("修改分：" + zonedDateTime4);
        ZonedDateTime zonedDateTime5 = now.withSecond(10);
        System.out.println("修改秒：" + zonedDateTime5);
        ZonedDateTime zonedDateTime6 = now.withNano(10);
        System.out.println("修改纳秒：" + zonedDateTime6);


        System.out.println("-------------------------Instant 时间戳、时间线 代替 Date -------------------------");
        // 获取当前时间的Instant对象
        Instant instant = Instant.now();
        System.out.println("获取当前时间的Instant对象：" + instant);
        long epochSecond = instant.getEpochSecond();
        System.out.println("获取秒：" + epochSecond);
        int nano2 = instant.getNano();
        System.out.println("获取纳秒：" + nano2);
        Instant instant1 = instant.plusSeconds(1);
        System.out.println("加一秒：" + instant1);
        Instant instant2 = instant.minusSeconds(1);
        System.out.println("减一秒：" + instant2);
        boolean equals = instant1.equals(instant2);
        System.out.println("是否相等：" + equals);
        boolean after = instant1.isAfter(instant2);
        System.out.println("是否在指定时间之后：" + after);
        boolean before = instant1.isBefore(instant2);
        System.out.println("是否在指定时间之前：" + before);

        System.out.println("-------------------------DateTimeFormatter 用于时间的格式化和解析 代替 SimpleDateFormat -------------------------");
        String formatted = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒").format(localDateTime);
        System.out.println("格式化：" + formatted);
        LocalDateTime parse = LocalDateTime.parse(formatted, DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒"));
        System.out.println("解析：" + parse);

        System.out.println("-------------------------Period 用于计算两个日期之间的间隔 代替 DateUtils -------------------------");
        Period between = Period.between(localDate, localDate.plusYears(1));
        int years = between.getYears();
        System.out.println("相差年：" + years);
        int months = between.getMonths();
        System.out.println("相差月：" + months);


        System.out.println("-------------------------Duration 用于计算两个时间之间的间隔 代替 DateUtils -------------------------");
        Duration duration = Duration.between(instant1, instant2);
        System.out.println("相差秒：" + duration.getSeconds());
        System.out.println("相差纳秒：" + duration.getNano());
        System.out.println("相差毫秒：" + duration.toMillis());
        System.out.println("相差分钟：" + duration.toMinutes());
        System.out.println("相差小时：" + duration.toHours());
        System.out.println("相差天：" + duration.toDays());


    }
}