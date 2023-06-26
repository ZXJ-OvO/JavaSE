package com.zxj.day11;

/**
 * 水果都能被榨成汁,在现实生活中,我们需要一个榨汁机,
 * 往榨汁机中的装什么水果就被榨成什么果汁,请根据描述设计一个程序
 */
public class Question05 {
    public static void main(String[] args) {
        Juicer fruit = new Fruit();
        fruit.run("Apple");
    }
}

interface Juicer {
    public void run(String fruit);
}

class Fruit implements Juicer {

    @Override
    public void run(String fruit) {
        System.out.println(fruit + "被丢进榨汁机");
    }
}