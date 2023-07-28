package com.zxj.day11;

import lombok.Getter;

/**
 * 抽象类
 */
@Getter
public abstract class Question07 {
    private String name;

    public Question07(){}

    public void setName(String name) {
        this.name = name;
    }

    public abstract void run();
}
