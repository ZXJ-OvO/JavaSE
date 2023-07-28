package com.zxj.day11;

/**
 * 多态下不能使用子类特有的方法，但是可以使用强制类型转换
 */
public class Question03 {
    public static void main(String[] args) {
        SmartAudi smartAudi = new SmartAudi();
        smartAudi.run();
        smartAudi.automaticDriving();
        smartAudi.automaticParking();

    }
}

class Audi {
    public void run() {
        System.out.println("run");
    }
}

class SmartAudi extends Audi {

    public void automaticParking() {
        System.out.println("automaticParking");
    }

    public void automaticDriving() {
        System.out.println("automaticDriving");
    }
}