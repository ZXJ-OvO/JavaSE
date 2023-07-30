package com.zxj.day15;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 1、创建四个List集合对象，分别用来存储3个玩家的牌以及底牌
 * 2、遍历牌盒将合适的牌存储到上述指定的集合中
 * 3、看牌就是对集合的元素进行遍历
 * 4、【选做】对每人手上的牌进行排序，从小到大的方式.[3,4,5,6,7,8,9,10,J,Q,K,A,2,王]
 */
public class Question17 {
    public static void main(String[] args) {
        ArrayList<String> player1 = CollUtil.newArrayList();
        ArrayList<String> player2 = CollUtil.newArrayList();
        ArrayList<String> player3 = CollUtil.newArrayList();
        ArrayList<String> underCard = CollUtil.newArrayList();

        // 准备54张牌
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        String[] kings = {"🃏", "🃏"};

        // 将牌放入牌盒
        ArrayList<String> cardBox = CollUtil.newArrayList();
        for (String color : colors) {
            for (String number : numbers) {
                cardBox.add(color + number);
            }
        }
        Collections.addAll(cardBox, kings);

        // 洗牌
        Collections.shuffle(cardBox);
        for (int i = cardBox.size(); i > 0; i--) {
            String remove = cardBox.remove(cardBox.size() - 1);
            if (player1.size() < 17) {
                player1.add(remove);
                continue;
            }
            if (player2.size() < 17) {
                player2.add(remove);
                continue;
            }
            if (player3.size() < 17) {
                player3.add(remove);
                continue;
            }
            underCard.add(remove);
        }

        System.out.println("玩家1的牌：" + player1);
        System.out.println("玩家2的牌：" + player2);
        System.out.println("玩家3的牌：" + player3);
        System.out.println("底牌：" + underCard);

    }
}
