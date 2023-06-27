package com.zxj.day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * API Date
 */
public class Question05 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();

        // 返回从1970年1月1日0时0分0秒到现在的毫秒数
        long timeMills = date.getTime();
        System.out.println(timeMills);

        // 时间毫秒值转换成日期对象
        Date currentTime = new Date(timeMills);
        System.out.println(currentTime);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        // 日期对象转换成字符串
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        // 时间毫秒值转化成字符串
        String formatted = simpleDateFormat.format(timeMills);
        System.out.println(formatted);

        // 时间字符串转换成日期对象
        Date parse = simpleDateFormat.parse(format);
        System.out.println(parse.toString());


    }
}
