package com.zxj.day19;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Question14 {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        FutureTask<Integer> futureTask1 = new FutureTask<>(bank);
        FutureTask<Integer> futureTask2 = new FutureTask<>(bank);
        Thread thread1 = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);
        thread1.setName("小明");
        thread1.start();
        thread2.setName("小红");
        thread2.start();
        Integer first = futureTask1.get();
        Integer second = futureTask2.get();

        System.out.println(thread1.getName() + " 取走了2000  银行余额：" + first);
        System.out.println(thread2.getName() + " 取走了2000  银行余额：" + second);

        if (Bank.balance < 0) {
            System.out.println("银行亏钱！");
            System.out.println("🏦余额：" + Bank.balance);
        }
    }
}



class Bank implements Callable<Integer> {
    public static Integer balance = 2000;

    @Override
    public synchronized Integer call() {
        balance -= 2000;
        return balance;
    }
}
