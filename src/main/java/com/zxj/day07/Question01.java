package com.zxj.day07;

import lombok.Data;

/**
 * 打印出学生的总成绩、平均成绩
 */
public class Question01 {
    public static void main(String[] args) {
        Student huawei = new Student();
        Student xiaomi = new Student();
        huawei.setName("huawei");
        xiaomi.setName("xiaomi");
        huawei.setScore(100);
        xiaomi.setScore(90);
        int totalScore = huawei.getScore() + xiaomi.getScore();
        System.out.println("总成绩：" + totalScore);
        System.out.println("平均成绩：" + totalScore / 2);

    }
}

@Data
class Student {
    private String name;
    private int score;
}