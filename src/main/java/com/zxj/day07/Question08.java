package com.zxj.day07;

/**
 * 中国使用的公历有闰年的说法,闰年的规则是:
 * 四年一闰,百年不闰,四百年再闰。
 * (年份能够被4整除但不能被100整除算是闰年,年份能被400整除也是闰年).
 * 请打印出1988年到2020年的所有闰年年份。
 * 1、for循环 , if语句的使用
 * 2、使用for循环拿到1988年到2020年的所有年份
 * 3、提供if语句过滤出闰年的年份, 进行输出打印
 */
public class Question08 {
    public static void main(String[] args) {
        for (int i = 1988; i <= 2020; i++) {
            if (i % 4 == 0 && i % 100 != 0){
                System.out.print("润年：" + i + "\t");
            }
        }
    }
}
