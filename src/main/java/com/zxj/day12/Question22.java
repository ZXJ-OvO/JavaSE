package com.zxj.day12;

public class Question22 {
    public static void main(String[] args) {
        A2 a1 = new A2();

        a1.methodA(() -> System.out.println("我是没有名字的InterA的实现类"));

        a1.methodA(() -> System.out.println("我有名字的InterA的实现类"));

    }
}

//定义接口
interface InterA {
    void showA();
}

class A2 {
    public void methodA(InterA a) {
        a.showA();
    }
}