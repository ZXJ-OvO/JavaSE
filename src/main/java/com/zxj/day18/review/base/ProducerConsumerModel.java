package com.zxj.day18.review.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者-消费者 模型
 */
public class ProducerConsumerModel {
    public static void main(String[] args) {
        Ware ware = new Ware();

        ProducerThread producerThread1 = new ProducerThread("生产者1", ware);
        ProducerThread producerThread2 = new ProducerThread("生产者2", ware);
        ProducerThread producerThread3 = new ProducerThread("生产者3", ware);
        producerThread1.start();
        producerThread2.start();
        producerThread3.start();

        ConsumerThread consumerThread1 = new ConsumerThread("消费者1", ware);
        ConsumerThread consumerThread2 = new ConsumerThread("消费者2", ware);
        consumerThread1.start();
        consumerThread2.start();

    }
}

/**
 * 数据器皿
 */
class Ware {
    private final List<String> data = new ArrayList<>();

    public synchronized void deposit() throws InterruptedException {
        String name = Thread.currentThread().getName();
        if (data.isEmpty()) {
            data.add(name + "  生产的数据");
            System.out.println(name + "  生产  一个数据");
        }
        this.notifyAll();
        this.wait();
    }

    public synchronized void draw() throws InterruptedException {
        String name = Thread.currentThread().getName();
        if (data.size() == 1) {
            String consumer = data.get(0);
            System.out.println(name + "  消费  " + consumer + "\n");
            data.clear();
        }
        this.notifyAll();
        this.wait();
    }
}

/**
 * 生产者线程
 */
class ProducerThread extends Thread {
    private final Ware ware;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                ware.deposit();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public ProducerThread(String name, Ware ware) {
        super(name);
        this.ware = ware;
    }

}

/**
 * 消费者线程
 */
class ConsumerThread extends Thread {
    private final Ware ware;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                ware.draw();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ConsumerThread(String name, Ware ware) {
        super(name);
        this.ware = ware;
    }
}