package com.zxj.day10;

public class Question17 {
    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.showName();
    }
}

class Zi extends Fu {
    String name = "子类";

    public void showName() {
        String name = "局部";
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }
}

class Fu {
    String name = "父类";
}