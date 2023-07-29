package com.zxj.day19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 线程安全问题
 */
public class Question16 {
    public static void main(String[] args) {
        Account acc = new Account("ICBC-111", 1000);
        Thread t1 = new DrawThread(acc, "小红");
        Thread t2 = new DrawThread(acc, "小明");
        // public  Thread(Runnable  target,  String  name)
        // 封装Runnable对象成为线程对象，并指定线程名称
        // DrawThread类继承了Thread，Thread实现了Runnable接口
        t1.start();
        t2.start();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Account {
    private String cardId;
    private double money;

    public void drawMoney(double money) {
        String name = Thread.currentThread().getName();
        synchronized (this) {   // this为当前账户对象：this == acc
            if (this.money >= money) {
                System.out.println(name + "来取钱，吐出：" + money);
                this.money -= money;
                System.out.println(name + "取钱后，余额剩余：" + this.money);
            } else {
                System.out.println(name + "来取钱，余额不足！");
            }
        }

    }
}


class DrawThread extends Thread {
    private Account acc;

    public DrawThread(Account acc, String name) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        acc.drawMoney(1000);
    }
}
