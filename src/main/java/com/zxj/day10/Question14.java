package com.zxj.day10;

/**
 * 单例设计模式
 */
public class Question14 {
    public static void main(String[] args) {
        A a = A.returnObject();
        A a1 = A.returnObject();
        System.out.println(a == a1);
    }
}

/**
 * 饿汉单例
 */
class A {
    // 提供单例对象
    private final static A a = new A();

    // 构造器私有
    private A() {

    }

    // 保护单例对象防止篡改
    public static A returnObject() {
        return a;
    }
}
