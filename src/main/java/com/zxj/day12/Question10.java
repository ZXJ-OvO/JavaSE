package com.zxj.day12;

public class Question10 {
    public static void main(String[] args) {
        // 请补齐代码，调用method方法
        method();
    }

    //定义静态方法
    public static void method() {
        // 请补齐代码，调用Person类中的eat方法
        Person.eat();
    }
}

class Person {
    public static void eat() {
        System.out.println("吃饭!");
    }
}