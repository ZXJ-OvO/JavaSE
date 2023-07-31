package com.zxj.day18.review.base;

/**
 * 线程常用API
 */
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行结束");
        });

        // 线程启动
        thread.start();

        // 线程是否存活
        System.out.println(thread.isAlive() + " 线程是否存活");

        // 线程名称
        System.out.println(thread.getName() + " 线程名称");

        // 线程ID
        System.out.println(thread.getId() + " 线程ID");

        // 当前线程
        System.out.println(Thread.currentThread() + " 当前线程");

        // 设置线程名
        thread.setName("线程1");
        System.out.println(thread.getName() + " 线程名称");

        // 等待目标线程执行结束
        thread.join();

        // 为线程指定名字
        Thread thread1 = new Thread("子线程1");

        // 封装Runnable接口为参数的构造方法Thread对象
        new Thread(() -> {});

        // 封装Runnable接口并指定名字 public Thread(Runnable target, String name)

    }
}