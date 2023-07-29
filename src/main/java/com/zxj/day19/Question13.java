package com.zxj.day19;

/**
 * Thread的常用方法
 */
public class Question13 {
    public static void main(String[] args) throws Exception {

        Thread2 thread2 = new Thread2();
        thread2.start();

        Thread2 thread21 = new Thread2();
        thread21.start();

        thread21.join();
        thread2.join();
        System.out.println("通过join控制主线程的运行");
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        String name = this.getName();
        Thread thread = Thread.currentThread();
        String name1 = thread.getName();
        System.out.println("对象调用getName拿到的线程名" + name + "\n" +
                "静态方法currentThread拿到当前的线程的名字：" + name1);
    }
}
