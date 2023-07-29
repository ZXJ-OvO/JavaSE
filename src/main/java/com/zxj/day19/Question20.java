package com.zxj.day19;

/**
 * 用两个线程玩猜数字游戏，第一个线程负责随机给出1~100之间的一个整数，第二个线程负责猜出这个数。
 * 1. 每当第二个线程给出自己的猜测后，第一个线程都会提示“猜小了”、“猜 大了”或“猜对了”。
 * 2. 猜数之前，要求第二个线程要等待第一个线程设置好 要猜测的数。
 * 3. 第一个线程设置好猜测数之后，两个线程还要相互等待，其原则是：
 * - 第二个线程给出自己的猜测后，等待第一个线程给出的提示；
 * - 第一个 线程给出提示后，第二个线程根据第一个线程给出的提示设置边界，缩小猜测范围，如此进行，直到第二个线程给 出正确的猜测后，两个线程进入死亡状态。
 */
public class Question20 {

    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        Thread thread1 = new Thread(guessNumber);
        Thread thread2 = new Thread(guessNumber);
        thread1.start();
        thread2.start();
        synchronized (guessNumber) {
            guessNumber.notify();
        }


    }

}

class GuessNumber implements Runnable {
    private static int number;
    private int num = 1;

    static {
        System.out.println("猜数字游戏开始");
        number = (int) (Math.random() * 100);
        System.out.println("第一个线程随机生成的数字为：" + number);
    }


    @Override
    public void run() {
        while (true) {
            this.num = (int) (Math.random() * 100);
            System.out.println("第二个线程猜的数字为：" + num);
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (check(num)) {
                System.out.println("第二个线程猜对了");
                break;
            }

        }
    }

    public boolean check(int num) {
        if (num > number) {
            System.out.println("猜大了");
            return false;
        }
        if (num < number) {
            System.out.println("猜小了");
            return false;
        }
        return true;
    }
}