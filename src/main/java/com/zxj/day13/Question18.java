package com.zxj.day13;

import cn.hutool.core.date.DateTime;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 */
public class Question18 {
    public static void main(String[] args) {
        // 创建一个定时器对象
        Timer timer = new Timer();
        timer.schedule(new TimeTask(), 0, 1000);         // 每隔1秒执行一次
    }
}


class TimeTask extends TimerTask {


    private final DateTime dateTime;

    public TimeTask() {
        this.dateTime = DateTime.of("2023-07-18 21:30:00", "yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public void run() {
        DateTime now = DateTime.now();
        now.between(dateTime);
        System.out.println("秒杀即将开始，距离开始还有：" + now.between(dateTime));
    }

}
