package com.zxj.day13;

import cn.hutool.core.date.DateTime;

/**
 * **需求**：
 * 某护士小花，作息规律为上两天班，休息一天，经常不确定休息日是否是周末（**注：首次休息日是2022年2月3日**）。
 * **具体功能点的要求如下**
 * 1、请你开发一个程序，当小花输入年以及月后，立即显示出该月份的休息日详情。
 * 示范（注意：示范信息重点在于参考格式，结果不一定是准确的，请自行确保计算结果正确性）：
 * 请小花输入查询的月份（月份必须是2022年2月之后的月份）： 2023-5 。**
 * 2023-5-1[休息]   2023-5-2   2023-5-3  2023-5-4[休息] ...**
 * 2、显示出该月份哪些休息日是周六或周日（请依次列出具体的日期和其星期信息）。
 * 3、小花给自己设置了一个高考倒计时。高考的开始时间为：2023年06月07日 上午9：00 。**请利用给的素材代码（在Timer文件夹下）**，补全代码，产生一个如下的倒计时效果，倒计时格式如下图所示：
 */
public class Question14 {
    public static void main(String[] args) {
        showRestDay();

    }

    public static void showRestDay() {
        DateTime dateTime = new DateTime();
        boolean weekend = dateTime.isWeekend();
        System.out.println(weekend);
    }
}
