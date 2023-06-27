package com.zxj.day13;

import java.text.SimpleDateFormat;

/**
 * 秒杀活动
 * 小贾下单并付款的时间为：2023年11月11日 0:01:18
 * 小皮下单并付款的时间为：2023年11月11日 0:10:51
 * 请用代码说明这两位同学有没有参加上秒杀活动？
 * 秒杀开始：2023年11月11日 0:0:
 * 秒杀结束：2023年11月11日 0:10:0
 */
public class Question06 {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String a = "2023年11月11日 0:01:18";
        String b = "2023年11月11日 0:10:51";
        String start = "2023年11月11日 0:0:0";
        String end = "2023年11月11日 0:10:0";
        // 解析要求时间字符串的格式必须和SimpleDateFormat对象的格式一致
        long time = simpleDateFormat.parse(a).getTime();
        long time1 = simpleDateFormat.parse(b).getTime();
        long time2 = simpleDateFormat.parse(start).getTime();
        long time3 = simpleDateFormat.parse(end).getTime();
        if (time >= time2 && time <= time3) {
            System.out.println("小贾参加了秒杀活动");
        } else {
            System.out.println("小贾没有参加秒杀活动");
        }
        if (time1 >= time2 && time1 <= time3) {
            System.out.println("小皮参加了秒杀活动");
        } else {
            System.out.println("小皮没有参加秒杀活动");
        }
    }
}
