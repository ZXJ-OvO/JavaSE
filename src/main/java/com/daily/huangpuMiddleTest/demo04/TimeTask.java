package com.daily.huangpuMiddleTest.demo04;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 闹钟的开始时间为：2023年07日24日 07:30:00 ，
 * 倒计时要展示剩余：多少天多少时多少分和多少秒。
 * 且闹钟时间到了后输出：小泰起床！并直接关闭程序
 * （可以通过this.cancel();这行代码关闭定时器执行，也就是关闭程序）！
 */
public class TimeTask extends TimerTask {
    // 用于记录闹钟的开始时间
    private LocalDateTime startTime;

    // 构造器，对闹钟的开始时间进行初始化
    public TimeTask() {
        String s = "2023年07月23日 17:53:20";
        // TODO: 2023/7/23

        DateTime currentDate = new DateTime(s, "yyyy年MM月dd日 HH:mm:ss");
        startTime = currentDate.toLocalDateTime();
    }

    // 每一秒执行一次该方法
    @Override
    public void run() {
        DateTime targetDate = new DateTime(startTime);
        DateTime currentDate = new DateTime();
        String s = DateUtil.formatBetween(currentDate, targetDate);
        System.out.println(s);

        if (currentDate.isAfterOrEquals(targetDate)) {
            System.out.println("小泰起床！");
            this.cancel();
            System.exit(1);
        }

    }


}

class Start {

    public static void main(String[] args) {
        // 创建一个定时器对象
        Timer timer = new Timer();
        // 每隔1秒执行一次new TimeTask()里的run方法
        timer.schedule(new TimeTask(), 0, 1000);
    }
}
