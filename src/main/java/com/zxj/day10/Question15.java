package com.zxj.day10;

/**
 * 懒汉单例模式
 */
public class Question15 {
    public static void main(String[] args) {
        AB instance = AB.getInstance();
        AB instance1 = AB.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
    }
}

class AB {
    private static AB ab;

    private AB() {

    }

    public static AB getInstance() {
        if (ab == null) {
            ab = new AB();
        }
        return ab;
    }
}
