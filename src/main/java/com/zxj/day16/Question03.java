package com.zxj.day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * 总共有54张牌
 * 点数: "3","4","5","6","7","8","9","10","J","Q","K","A","2"
 * 花色: "♠", "♥", "♣", "♦“
 * 大小王: "Boss" , "boss"
 * 斗地主：发出51张牌，每人17张牌，剩下3张做为底牌。
 * 在启动游戏房间的时候，应该提前准备好54张牌
 * 接着，需要完成洗牌、发牌、对牌排序、看牌等功能
 */
public class Question03 {
    public static void main(String[] args) {
        ArrayList<String> pokerHeapBasic = new ArrayList<>();
        ArrayList<String> pokerHeapColor = new ArrayList<>();
        ArrayList<StringBuilder> pokerHeapBoss = new ArrayList<>();
        ArrayList<StringBuilder> pokerHeapArrayList = new ArrayList<>();
        ArrayList<StringBuilder> person1 = new ArrayList<>();
        ArrayList<StringBuilder> person2 = new ArrayList<>();
        ArrayList<StringBuilder> person3 = new ArrayList<>();

        // 备牌
        Collections.addAll(pokerHeapBasic, "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2");
        Collections.addAll(pokerHeapColor, "♠", "♥", "♣", "♦");
        Collections.addAll(pokerHeapBoss, new StringBuilder("Boss"), new StringBuilder("boss"));

        // 生成基本花色牌
        for (String s : pokerHeapColor) {
            for (String value : pokerHeapBasic) {
                StringBuilder builder = new StringBuilder(s);
                pokerHeapArrayList.add(builder.append(value));
            }
        }

        // 添加大小王
        Collections.addAll(pokerHeapArrayList, pokerHeapBoss.get(0), pokerHeapBoss.get(1));

        // 打乱顺序洗牌
        Collections.shuffle(pokerHeapArrayList);

        // 发牌
        Random random = new Random();
        // person1为地主，剩下两个人为农民，地主先发牌，逆时针旋转发牌，person2为地主下顺位，person3为地主上顺位，本案例不考虑顺位发牌问题
        for (int i = 0; i < 17; i++) {
            person1.add(pokerHeapArrayList.remove(random.nextInt(pokerHeapArrayList.size())));
        }

        for (int i = 0; i < 17; i++) {
            int anInt = random.nextInt(pokerHeapArrayList.size() - 17);
            if (person1.get(i).equals(pokerHeapArrayList.get(anInt))) {
                i--;
            } else {
                person2.add(pokerHeapArrayList.remove(anInt));
            }
        }
        for (int i = 0; i < 17; i++) {
            int anInt = random.nextInt(pokerHeapArrayList.size() - 3);
            if (person1.get(i).equals(pokerHeapArrayList.get(anInt)) || person2.get(i).equals(pokerHeapArrayList.get(anInt))) {
                i--;
            } else {
                person3.add(pokerHeapArrayList.remove(anInt));
            }
        }


        // todo 排序 3 4 5 6 7 8 9 10 J Q K A 2 boss Boss
        // 匹配所有花色并删除花色，然后根据点数排序，且大小王放在最后
        Collections.sort(person1, new PokerComparator());
        Collections.sort(person2, new PokerComparator());
        Collections.sort(person3, new PokerComparator());

        // 看牌
        System.out.println("底牌：" + pokerHeapArrayList);

        System.out.println("首发地主牌库：" + person1);
        System.out.println("下位农民牌库：" + person2);
        System.out.println("上位农民牌库：" + person3);

    }

    // 自定义比较器实现对牌的排序
    static class PokerComparator implements Comparator<StringBuilder> {
        @Override
        public int compare(StringBuilder o1, StringBuilder o2) {
            String value1 = o1.substring(1);
            String value2 = o2.substring(1);

            String[] values = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "boss", "Boss"};

            int index1 = 0;
            int index2 = 0;

            for (int i = 0; i < values.length; i++) {
                if (value1.equals(values[i])) {
                    index1 = i;
                }
                if (value2.equals(values[i])) {
                    index2 = i;
                }
            }
            if (index1 == 13 && index2 == 14) {
                return -1;
            } else if (index1 == 14 && index2 == 13) {
                return 1;
            } else {
                return Integer.compare(index1, index2);
            }
        }
    }

}


