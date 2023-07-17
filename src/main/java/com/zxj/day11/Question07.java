package com.zxj.day11;

/**
 * 抽象类
 */
public abstract class Question07 {
    private String name;

    public Question07(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void run();
}
