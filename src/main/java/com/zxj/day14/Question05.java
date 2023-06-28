package com.zxj.day14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请把文本中的电话，邮箱，座机号码，热线都爬取出来。
 */
public class Question05 {
    public static void main(String[] args) {
        String text = "学习Java，\n" +
                "电话：18512516758，18512508907\n" +
                "或者联系邮箱： boniu@itcast.cn\n" +
                "座机电话：01036517895，010-98951256\n" +
                "邮箱：bozai@itcast.cn，\n" +
                "邮箱2：dlei0009@163.com，\n" +
                "热线电话：400-618-9090 ，400-618-4000，\n" +
                "4006184000，4006189090";

        // 匹配电话号码
        Pattern phonePattern = Pattern.compile("\\b(1[3-8]\\d{9})\\b");     // \b代表单词边界  、B代表非单词柏楠姐

        Matcher phoneMatcher = phonePattern.matcher(text);
        System.out.println("电话号码：");
        while (phoneMatcher.find()) {
            System.out.println(phoneMatcher.group());
        }

        // 匹配邮箱
        Pattern emailPattern = Pattern.compile("\\b([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})\\b");
        Matcher emailMatcher = emailPattern.matcher(text);
        System.out.println("邮箱：");
        while (emailMatcher.find()) {
            System.out.println(emailMatcher.group());
        }

        // 匹配座机号码
        Pattern landlinePattern = Pattern.compile("\\b(0\\d{2,3}[- ]?\\d{7,8})\\b");
        Matcher landlineMatcher = landlinePattern.matcher(text);
        System.out.println("座机号码：");
        while (landlineMatcher.find()) {
            System.out.println(landlineMatcher.group());
        }

        // 匹配热线电话
        Pattern hotlinePattern = Pattern.compile("\\b(400[- ]?\\d{3}[- ]?\\d{4})\\b");
        Matcher hotlineMatcher = hotlinePattern.matcher(text);
        System.out.println("热线电话：");
        while (hotlineMatcher.find()) {
            System.out.println(hotlineMatcher.group());
        }
    }

}

