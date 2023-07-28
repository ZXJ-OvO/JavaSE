package com.zxj.day14;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * 奖品种类总共有4种：一等奖、二等级、三等奖、谢谢惠顾。为了节约成本需要控制每一种奖项的抽取概率，
 * 常见的做法就是给每一个奖项分配一个int类型的权重值，权重越大抽取到的概率就越大。下图是具体的奖项权重值分配情况：
 * |  奖项  | 一等奖  | 二等奖  | 三等奖  | 谢谢惠顾 |
 * | :--: | :--: | :--: | :--: | :--: |
 * |  权重  |  1   |  2   |  3   |  4   |
 * 1、所有奖项的总权重，以及每一个奖项的权重范围 , 如下所示：
 * |  奖项  |  一等奖  |  二等奖  |  三等奖  |  四等奖   |
 * | :--: | :---: | :---: | :---: | :----: |
 * | 权重范围 | [0,1) | [1,3) | [3,6) | [6,10) |
 * 2、生成一个随机数作为权重数
 * 3、利用二分查找根据权重数从奖项数组中获取对应的奖项
 * 4、控制台输出奖项名称
 */
public class Question15 {
    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        // 定义奖项数组,并为其设置值
        ArrayList<Awards> awards = CollUtil.newArrayList(
                new Awards("一等奖", 1, 0, 1),
                new Awards("二等奖", 2, 1, 3),
                new Awards("三等奖", 3, 3, 6),
                new Awards("谢谢惠顾", 4, 6, 10));

        ArrayList<Integer> list = CollUtil.newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int random = 0;
        for (int i = 0; i < 150; i++) {
            random = (int) (Math.random() * 10);
            if (random == 0) {
                System.out.println("恭喜你抽中了" + awards.get(0).getName());
                continue;
            }
            if (random >= 1 && random < 3) {
                System.out.println("恭喜你抽中了" + awards.get(1).getName());
                continue;
            }
            if (random >= 3 && random < 6) {
                System.out.println("恭喜你抽中了" + awards.get(2).getName());
                continue;
            }
            if (random >= 6 && random < 10) {
                System.out.println("恭喜你抽中了" + awards.get(3).getName());
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);


    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Awards {           // 奖项
    private String name;       // 奖项名称
    private int weight;        // 权重
    private int low;           // 权重区间最小值
    private int high;
}