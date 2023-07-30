package com.zxj.day10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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

}

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
class Bear extends Animals {
    public String color;
    public int legNum;

}

class Panda extends Animals {

}
