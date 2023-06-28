package com.zxj.day14;

/**
 * 正则表达式校验
 * 手机号：1开头，第二位3-9，后面9位数字
 * 邮箱：数字、字母、下划线、-、.、@，@前面不能是特殊字符
 * 时间格式：
 * 时间从1989-06-04 00:00:00到2023-06-04 00:00:00
 * 年份要在1989到2023之间
 * 月份不能为0，不能超过12，不满两位数要补0
 * 日期不能超过31，不满两位数要补0
 * 每个日期之间使用-分割 年月日与时分秒之间使用空格分割
 * 小时不能超过23，不满两位数要补0，要大于等于00
 * 分钟不能超过59，不满两位数要补0，要大于等于00
 * 秒不能超过59，不满两位数要补0，要大于等于00
 */
public class Question04 {
    public static void main(String[] args) {
        String str = "13688888888";
        String regx = "1[3-9]\\d{9}";
        System.out.println(str.matches(regx));

        String str2 = "zxjOvO@gmail.com";
        String regx2 = "\\w{5,10}@\\w{3,5}.com";
        System.out.println(str2.matches(regx2));

        String str3 = "2020-12-12 12:12:12";
        String regx3 = "((1989|199[0-9]|200[0-9]|201[0-9]|202[0-3])-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])) (([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9]))";
        System.out.println(str3.matches(regx3));
    }
}
