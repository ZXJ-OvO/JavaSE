package com.zxj.day12;

/**
 * 匿名内部类
 */
public class Question01 {
    public static void main(String[] args) {
        Swimming swimming = () -> System.out.println("狗油的飞快");
        swimming.swim();

        Swimming swimming1 = () -> System.out.println("猫游得飞快");
        swimming1.swim();

    }

    public static void run() {
        //swimming.swim();
    }
}


interface Swimming {
    void swim();
}

