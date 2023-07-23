package com.daily.huangpuMiddleTest.demo01;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

/**
 * 某双色球系统，红球是1-35之间的数据，篮球是1-15之间的数据，一注双色球号码是由6个不重复的号码和1个篮球号码组成的。
 * * 请随机一组双色球号码，6个红球号码要求不重复，且升序排序输出，篮球号码放在最后面输出。
 * <p>
 * * 假设上图展示的是中奖号码，请用程序判断出第一个功能随机出的双色球号码中了几个红球和几个篮球。
 */
public class Test01 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();

        while (hashSet.size() < 6) {
            int randomInt = RandomUtil.randomInt(1, 36);
            hashSet.add(randomInt);
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(hashSet);
        Collections.sort(list);

        int blue = RandomUtil.randomInt(1, 16);
        list.add(blue);
        System.out.println("您投注的号码为：" + list);

        checkBonus(list);
    }

    private static void checkBonus(ArrayList<Integer> list) {
        ArrayList<Integer> bonusNumber = CollUtil.newArrayList(10, 12, 30, 16, 7, 17, 12);
        int redCount = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < bonusNumber.size() - 1; j++) {
                if (Objects.equals(bonusNumber.get(j), list.get(i))) redCount++;
            }
        }
        int blueCount = Objects.equals(bonusNumber.get(bonusNumber.size() - 1), list.get(list.size() - 1)) ? 1 : 0;
        System.out.println("您投注的号码命中了" + redCount + "个红球个" + blueCount + "蓝球");
    }
}
