package com.zxj.day19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

public class Question23 {
    public static void main(String[] args) {
        // 目标：完成题目三。
        // 1、创建数据容器对象。
        MyData data = new MyData();

        // 2、创建生产者线程和消费者线程
        new TipThread(data, "第一个线程").start();
        new GuessThread(data, "第二个线程").start();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class MyData {
    private int luckNumber;
    private int guessNumber;
    private String tip;
    private int start = 1;
    private int end = 100;

    public synchronized boolean tip() throws InterruptedException {
        String name = Thread.currentThread().getName();
        if (luckNumber == 0) {
            // 还没猜数字
            Random random = new Random();
            int number = random.nextInt(100) + 1;
            System.out.println(name + "产生了一个随机的幸运号码：" + number);

            luckNumber = number;
            this.notify();
            this.wait();
            return false;
        } else {
            // 一定是给提示的
            if (guessNumber > luckNumber) {
                end = guessNumber - 1;
                System.out.println(name + "温馨提示：您猜测的数字过大,范围在【" + start + "-->" + end + "】之间");
                this.notify();
                this.wait();
                return false;
            } else if (guessNumber < luckNumber) {
                start = guessNumber + 1;
                System.out.println(name + "温馨提示：您猜测的数字过小,范围在【" + start + "-->" + end + "】之间");
                this.notify();
                this.wait();
                return false;
            } else {
                System.out.println("恭喜您，猜对了！");
                this.notify();
                // 结束程序....
                return true;
            }
        }
    }

    public synchronized boolean guess() throws InterruptedException {
        String name = Thread.currentThread().getName();
        if (luckNumber == 0) {
            this.notify();
            this.wait();
            return false;
        } else {
            if (guessNumber == luckNumber) {
                return true;
            }

            Random random = new Random();
            // start - end ===>  (0 , end - start) + start
            int number = random.nextInt(end - start + 1) + start;
            guessNumber = number;
            System.out.println(name + "开始猜一个新数字：" + number);
            this.notify();
            this.wait();
            return false;
        }
    }
}

class TipThread extends Thread {
    private MyData data;

    public TipThread(MyData data, String name) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        // 启动。
        while (true) {
            try {
                Thread.sleep(1000);
                if (data.tip()) break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class GuessThread extends Thread {
    private MyData data;

    public GuessThread(MyData data, String name) {
        super(name);
        this.data = data;
    }


    @Override
    public void run() {
        // 启动。
        while (true) {
            try {
                Thread.sleep(1000);
                if (data.guess()) break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}