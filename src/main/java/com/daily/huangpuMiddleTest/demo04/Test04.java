package com.daily.huangpuMiddleTest.demo04;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 上三天，休息一天，周六日双休，然后顺延上三天班休息一天。该员工第一次休息日是2022-03-02日。
 * 1、请你开发一个程序，当小泰输入年以及月后，立即显示出该月份的休息日详情。
 * 请小泰输入查询的月份（月份必须是2022年3月之后的月份）： 2023-5
 * 2023-5-1[周一-休息]   2023-5-2[周二-上班]   2023-5-3[周三-上班]  2023-5-4[周四-上班]  2023-5-5[周五-休息]
 * 2023-5-6[周六-休息] 2023-5-7[周日-休息] 2023-5-8[周一-上班] ...
 * 2、请找出小泰从此刻当月(例如：2023年7月) 到 未来五个月（总共6个月），哪个月份的休息日是最多的，总共是休息多少天，详情是怎么样的。
 * 3、小泰自己设置了一个闹钟，闹钟的开始时间为：2023年07日24日 07:30:00 ，
 * 倒计时要展示剩余：多少天多少时多少分和多少秒。且闹钟时间到了后输出：小泰起床！并直接关闭程序（可以通过this.cancel();这行代码关闭定时器执行，也就是关闭程序）！
 */
public class Test04 {
    public static void main(String[] args) {
        DateTime theFirstFreeDay = DateUtil.parseDate("2022-03-02");
        // 把输入的时间和第一次休假时间做成时间日期对象
        Scanner scanner = new Scanner(System.in);
        DateTime inputDateTime = null;
        while (true) {
            System.out.println("请输入年份");
            String yearInput = scanner.next();
            System.out.println("请输入月份");
            String monthInput = scanner.next();
            String strTime = yearInput + "-" + monthInput + "-01";
            inputDateTime = DateUtil.parseDate(strTime);

            if (inputDateTime.isBefore(theFirstFreeDay)) {
                System.out.println("月份必须是2022年3月之后");
                continue;
            }
            break;
        }
        getFreeDayCount(inputDateTime, theFirstFreeDay);
        System.out.println("------------------------------------------");
        HashMap<Integer, Integer> map = new HashMap<>();
        inputDateTime = DateUtil.parseDate("2022-07-01");
        for (int i = 0; i < 5; i++) {
            inputDateTime = inputDateTime.offsetNew(DateField.MONTH, 1);

            int free = getFreeDayCount(inputDateTime, theFirstFreeDay);
            int work = inputDateTime.getLastDayOfMonth() - free;

            map.put(7 + i, free);
            System.out.println((7 + i) + "月休假：" + free + "天");
            System.out.println((7 + i) + "月上班：" + work + "天");
        }

        Map<Integer, Integer> sortByValue = MapUtil.sortByValue(map, true);
        sortByValue.forEach((integer, integer2) -> System.out.println(integer + "月" + integer2 + "天"));

        Set<Integer> integers = sortByValue.keySet();
        Object[] array = integers.toArray();

        System.out.println("休假最多的月份：");

        for (int i = 0; i < array.length; i++) {
            if (sortByValue.get(array[i]) == sortByValue.get(array[0])) {
                System.out.print(array[i] + "月  ");
            }
        }
    }

    public static int getFreeDayCount(DateTime inputDateTime, DateTime theFirstFreeDay) {
        int freeDayCount = 0;
        int between = (int) inputDateTime.between(theFirstFreeDay, DateUnit.DAY);
        String[] dayEnum = new String[]{"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        int workDayCount = 0;
        DateTime currentTime = theFirstFreeDay;
        int lastDayOfMonth = inputDateTime.getLastDayOfMonth() - 1;
        for (int i = 0; i < between + lastDayOfMonth; i++) {
            workDayCount++;
            currentTime = DateUtil.offsetDay(currentTime, 1);
            String dateStr = currentTime.toDateStr();
            int dayOfWeekNum = currentTime.dayOfWeek() - 1;
            if (currentTime.isWeekend()) {
                workDayCount = 0;
                if (currentTime.isAfterOrEquals(inputDateTime)) {
                    System.out.println(dateStr + "[" + dayEnum[dayOfWeekNum] + "]休息");
                    freeDayCount++;
                    continue;
                }
            } else if (workDayCount % 4 == 0) {
                if (currentTime.isAfterOrEquals(inputDateTime)) {
                    workDayCount = 0;
                    System.out.println(dateStr + "[" + dayEnum[dayOfWeekNum] + "]休息");
                    freeDayCount++;
                    continue;
                }
            }
            if (currentTime.isAfterOrEquals(inputDateTime)) {
                System.out.println(dateStr + "[" + dayEnum[dayOfWeekNum] + "]上班");
            }
        }
        return freeDayCount;
    }
}