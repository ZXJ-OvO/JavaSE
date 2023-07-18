package com.hutool.date;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

/**
 * cn.hutool.core.date.DateUtil  日期工具类
 */
public class Util {


    public static void main(String[] args) {
        DateTime dateTime = new DateTime();

        System.out.println("当前时间的时间戳：\t" + DateUtil.current());
        System.out.println("获取指定年数的总天数：\t" + DateUtil.lengthOfYear(2023));

    }
}
