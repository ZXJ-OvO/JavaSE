package com.zxj.day19;

import cn.hutool.core.lang.Console;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建多线程的三种方式
 */
public class Question11 {
    public static final Logger logger = LoggerFactory.getLogger(Question11.class);

    public static void main(String[] args) throws Exception {

        // 方式一
        MyThread myThread = new MyThread();
        myThread.start();


        // 方式二
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        // new Thread(new Runnable) lambda创建
        new Thread(() -> {
            for (int i = 0; i < 5; i++)
                logger.info("实现Runnable接口的方式（Lambda）创建多线程->子线程继续执行" + i);
        }).start();


        // 方式三
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread thread1 = new Thread(futureTask);
        thread1.start();

        // 方式三lambda简化
        new Thread(new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 0; i < 5; i++) sum += i;
            return sum;
        }));

        // FutureTask执行get前会等待对应线程执行完成得到最终结果后再执行
        Console.log("Callable -> futureTask返回的运行结果：" + futureTask.get());

        // 阻塞等待
        myThread.join();
        for (int i = 0; i < 10; i++) {
            logger.info("主线程继续执行" + i);
        }

    }
}

/**
 * 继承Thread
 */
class MyThread extends Thread {
    public static final Logger logger = LoggerFactory.getLogger(MyThread.class);

    @Override
    public void run() {
        // 线程任务
        for (int i = 0; i < 5; i++) {
            logger.info("继承Thread的方式创建多线程->子线程继续执行" + i);
        }
    }
}

/**
 * 实现Runnable
 */
class MyRunnable implements Runnable {
    public static final Logger logger = LoggerFactory.getLogger(MyRunnable.class);

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            logger.info("实现Runnable接口的方式创建多线程->子线程继续执行" + i);
        }
    }
}

/**
 * 实现Callable接口，泛型指定返回结果
 */
class MyCallable implements Callable<Integer> {

    // 重写的是call()方法
    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += i;
        }
        return sum;
    }
}