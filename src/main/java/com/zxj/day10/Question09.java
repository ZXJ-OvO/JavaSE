package com.zxj.day10;

public class Question09 {
    public static void main(String[] args) {

        System.out.println(User.countObjectNumber);
    }
}

class User {
    // 静态变量，只有一份，记录对象创建的个数
    public static int countObjectNumber;

    public User() {
        // User.countObjectNumber++;
        countObjectNumber++;
    }
}