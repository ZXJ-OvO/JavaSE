package com.review.multiThread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.lang.Thread.sleep;

/**
 * 并发取钱-线程安全问题
 * <p>
 * 同步代码块：
 * synchronized  对于实例方法，可以使用当前对象 this 作为锁
 * synchronized  对于静态方法，可以使用当前 类.class 作为锁
 * <p>
 * 同步方法：
 * synchronized  隐式锁，同步方法的锁就是 this
 * <p>
 * Lock锁：
 * private final Lock lock = new ReentrantLock();
 * API           上锁 lock.lock();  解锁 lock.unlock(); （解锁要放在finally块预防异常）
 */
public class DrawMoneyThreadSafeProblem {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(1000);

        DrawThread thread0 = new DrawThread(account);
        DrawThread thread1 = new DrawThread(account);
        thread0.start();
        thread1.start();

        sleep(1000);
        System.out.println(account.getBalance());
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Account {
    private Integer balance;

    public synchronized void draw() throws InterruptedException {
        // 给核心逻辑加同步锁避免线程安全问题
        synchronized (this) {
            if (this.balance <= 0) {
                System.out.println("余额不足");
            } else {
                sleep(10);
                this.balance -= 1000;
                System.out.println(Thread.currentThread().getName() + "取走1000元");
            }
        }
    }
}

@NoArgsConstructor
@AllArgsConstructor
class DrawThread extends Thread {
    private Account account;

    @Override
    public void run() {
        try {
            account.draw();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}