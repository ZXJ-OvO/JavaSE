package com.zxj.day13;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

public class Question15 {
    public static void main(String[] args) {
        TimeInterval timer = DateUtil.timer();
      //  System.out.println(timer);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 10_0000; i++) {
            s.append("abc").append(i);
        }

        System.out.println(timer.interval() / 1000.0);//花费毫秒数

    }
}
