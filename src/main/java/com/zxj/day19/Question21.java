package com.zxj.day19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Question21 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> grades = new ArrayList<>();
        Collections.addAll(grades, 5, 10, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);

        Thread box1 = new GetThread(grades, "抽奖箱1");
        Thread box2 = new GetThread(grades, "抽奖箱2");

        box1.start();
        box2.start();

        box1.join();
        box2.join();

        System.out.println("最终是：" + GetThread.name+"抽中了最大奖，" + "最大值" + GetThread.max);

    }
}

class GetThread extends Thread {
    public static Integer max = 0;
    public static String name;
    private final List<Integer> grades;

    public GetThread(List<Integer> grades, String name) {
        super(name);
        this.grades = grades;
    }

    @Override
    public void run() {
        List<Integer> gradesList = new ArrayList<>();
        String name = Thread.currentThread().getName();
        while (true) {
            // 不用把锁放在死循环外面
            synchronized (grades) {

                if (grades.isEmpty()) {
                    break;
                }

                Random random = new Random();
                Integer grade = grades.remove(random.nextInt(grades.size()));
                gradesList.add(grade);

                if (grade > max){
                    max = grade;
                    GetThread.name = name;
                }
            }
        }

        System.out.println("在本次抽奖的过程中，" + name + "抽中的金额：" + gradesList);

    }
}