package com.zxj.day12;

public class Question19 {
    public static void main(String[] args) {

        go(() -> System.out.println("演示对象回调"));


    }

    public static void go(Swimming1 swimming1) {
        swimming1.swim();
    }
    interface Swimming1 {
        void swim();
    }
}

