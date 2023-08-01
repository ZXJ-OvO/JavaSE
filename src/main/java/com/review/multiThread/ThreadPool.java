package com.review.multiThread;

import java.util.concurrent.*;

/**
 * 线程池 参数、创建、方法、策略、注意事项
 * 1、临时线程什么时候创建？ 核心线程数满了，任务队列满了，最大线程数没满，临时线程才会创建
 * 2、什么时候拒绝新任务？ 核心线程数满了，任务队列满了，最大线程数满了，拒绝新任务
 * 3、新任务拒绝策略
 * ThreadPoolExecutor.AbortPolicy() 默认策略，直接抛出异常
 * ThreadPoolExecutor.CallerRunsPolicy() 调用者运行策略，谁调用的线程，谁执行任务
 * ThreadPoolExecutor.DiscardPolicy() 丢弃策略，直接丢弃任务，不抛出异常
 * ThreadPoolExecutor.DiscardOldestPolicy() 丢弃最老的策略，把任务队列中最老的任务丢弃，然后把新任务加入队列
 * 线程池七个参数：
 * 1、核心线程数 指定线程池中的核心线程数
 * 2、最大线程数 指定线程池中的最大线程数
 * 3、存活时间 指定线程池中的线程没有任务执行时最多保持多久时间会终止
 * 4、存活时间单位 指定线程池中的线程没有任务执行时最多保持多久时间会终止的单位
 * 5、任务队列 指定线程池中的任务队列，指代等待执行的任务
 * 6、线程工厂 指定线程池中创建线程的工厂
 * 7、拒绝策略 指定线程池中的任务队列满了之后采取的拒绝策略
 */
public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = new ThreadPoolExecutor(
                2,
                3,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        TestThreadPool thread = new TestThreadPool();
        pool.execute(thread); // 创建第一个任务 核心线程执行
        pool.execute(thread); // 创建第二个任务 核心线程执行
        pool.execute(thread); // 创建第三个任务 创建临时线程 临时线程执行
        pool.execute(thread); // 创建第四个任务 任务队列 临时线程执行
        pool.execute(thread); // 创建第五个任务 任务队列 临时线程执行
        pool.execute(thread); // 创建第五个任务 任务队列 临时线程执行
        // pool.execute(thread); // 创建第五个任务 触发拒绝策略

        // 等待所有任务执行完毕关闭线程池
        // pool.shutdown();

        // 强制关闭线程池
        // pool.shutdownNow();

        // 执行Callable任务，返回未来任务对象，用于获取线程返回的结果
        Future<String> future = pool.submit(() -> "hello");
        System.out.println(future.get());

        // Executors工具类创建线程池
        /*
            阿里巴巴开发规约：【禁止】 使用

            newFixedThreadPool(int nThreads) 创建一个可重用固定线程数的线程池，如果某个线程因为异常而结束，会补充一个新线程替代
            newCachedThreadPool() 线程数量随着任务的增加而增加，如果某个线程因为异常而结束，会补充一个新线程替代
            newSingleThreadExecutor() 创建一个单线程化的线程池，如果某个线程因为异常而结束，会补充一个新线程替代
            newScheduledThreadPool(int corePoolSize) 创建一个可定时执行任务的线程池，可以实现在给定的延迟后执行任务或者定期执行任务
         */

    }
}

class TestThreadPool extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行了任务");
    }
}

// 多线程是并发并行同时进行的