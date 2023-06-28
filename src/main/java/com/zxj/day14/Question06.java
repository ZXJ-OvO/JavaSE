package com.zxj.day14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 某系统的日志文件记录了当天进入系统的全部用户信息，需要把这些用户的名字爬取出来另作他用
 * 欢迎张全蛋光临本系统！他删库并跑路
 * 欢迎李二狗子光临本系统！
 * 欢迎马六子光临本系统！它浏览了很多好看的照片！
 * 欢迎夏洛光临本系统！他在六点钟送出了一个嘉年华
 */
public class Question06 {
    public static void main(String[] args) {
        String text = "欢迎张全蛋光临本系统！他删库并跑路欢迎李二狗子光临本系统！欢迎马六子光临本系统！它浏览了很多好看的照片！ 欢迎夏洛光临本系统！他在六点钟送出了一个嘉年华";

        String regex = "欢迎(.+?)光临";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(text);
        System.out.println("用户名：");
        while (matcher.find()) {
            String rs2 = matcher.group(1); // 获取第一组内容（就是人的名字）
            System.out.println(rs2);
        }
    }
}

