package com.zxj.day10;

public class Question09 {
    public static void main(String[] args) {
        User user = new User();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();

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