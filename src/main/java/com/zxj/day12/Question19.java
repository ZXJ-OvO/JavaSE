package com.zxj.day12;

public class Question19 {
    public static void main(String[] args) {
        Animal1 animal1 = new Animal1() {

            @Override
            public void run() {
                System.out.println("匿名内部类直接重写方法");
                System.out.println("通过反编译查看源码可知");
                System.out.println("匿名内部类本质是一个子类同时也是一个子类对象");
                System.out.println("反编译可知创建了两个class文件");
                System.out.println("在此处充当了子类对象");
            }
        };

        Swimming1 swimming1 = new Swimming1() {

            @Override
            public void swim() {
                System.out.println("演示对象回调");
            }
        };

        go(new Swimming1() {
            @Override
            public void swim() {
                System.out.println("演示对象回调");
            }
        });


    }

    public static void go(Swimming1 swimming1) {
        swimming1.swim();
    }
}

abstract class Animal1 {
    public abstract void run();
}

interface Swimming1 {
    void swim();
}