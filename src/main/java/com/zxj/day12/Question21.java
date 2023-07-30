package com.zxj.day12;

public class Question21 {
    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        outer1.a.show();
    }
}

interface Inter {
}

class Outer1 {
    A a = new A() {
    };
}

class A implements Inter {
    public void show() {
        System.out.println("HelloWorld");
    }
}
