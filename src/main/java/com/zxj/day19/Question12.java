package com.zxj.day19;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Question12 {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();

        Runnable1 runnable1 = new Runnable1();
        Thread thread = new Thread(runnable1);
        thread.start();

        Callable1 callable1 = new Callable1();
        FutureTask<String> stringFutureTask = new FutureTask<>(callable1);
        Thread thread2 = new Thread(stringFutureTask);
        thread2.start();

        System.out.println("主线程继续执行");

    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("方式一");
    }
}

class Runnable1 implements Runnable {
    @Override
    public void run() {
        System.out.println("方式二");
    }
}

class Callable1 implements Callable<String> {
    @Override
    public String call() {
        return "方式三";
    }


}