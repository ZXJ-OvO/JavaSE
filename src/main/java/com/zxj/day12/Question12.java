package com.zxj.day12;

/**
 * 今日,金燕龙110教室为学生的自习室,自习室中今天只来了大郎和金莲两个同学
 * 由于老师开会,需要占用教室,所以大郎和金莲两位学生需要更换到金燕龙111教室
 * 设计程序,完成需求.
 */
public class Question12 {
    public static void main(String[] args) {
        ITCast daLang = () -> System.out.println("大郎换教室到金燕龙111教室");
        ITCast JinLian = () -> System.out.println("金莲换教室到金燕龙111教室");

        daLang.changeRoom();
        JinLian.changeRoom();
    }
}

interface ITCast {
    void changeRoom();
}

