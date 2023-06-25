package com.zxj.day10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Question06 {
    public static void main(String[] args) {
        Panda panda = new Panda();
        Bear bear = new Bear();
        bear.setColor("黑色");
        panda.setColor("黑白相间");
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Animals {
    public String color;
    public int legNum;

    public void eat() {
        System.out.println("吃饭");
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Bear extends Animals {
    public String color;
    public int legNum;
    public void eat() {
        System.out.println(color);
        System.out.println("吃鱼");
    }

    private void sleep() {
        System.out.println("睡觉");
    }
}

class Panda extends Animals {
    public void eat() {
        System.out.println("吃人");
    }

    private void dance() {
        System.out.println("丫圣千古、国兽无双");
    }
}
