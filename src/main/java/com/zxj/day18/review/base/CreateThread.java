package com.zxj.day18.review.base;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的三种方式
 */
public class CreateThread {
    public static void main(String[] args) throws Exception {
        // 继承Thread类
        MyThread myThread = new MyThread();
        myThread.start();

        // 实现Runnable接口
        MyRunnable myRunnable = new MyRunnable();
        Thread myThreadRunnable = new Thread(myRunnable);
        myThreadRunnable.start();

        // 实现Callable接口
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread myThreadCallable = new Thread(futureTask);
        myThreadCallable.start();
        // 未来任务的get方法会阻塞主线程
        String result = futureTask.get();
        System.out.println(result);

        // 主线程
        System.out.println("未来任务的get方法会阻塞主线程，完成后才会执行");
    }

}

/**
 * 继承Thread类 实现简单
 */
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("继承Thread类创建线程");
    }
}

/**
 * 实现Runnable接口 宽展更强
 */
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("实现Runnable接口创建线程");
    }
}

/**
 * 实现Callable接口 扩展更强 允许返回值 编码复杂
 */
class MyCallable implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Thread.sleep(10000);
        return "实现Callable接口创建线程";
    }
}