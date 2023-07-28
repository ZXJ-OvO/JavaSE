package com.zxj.day16;

import java.util.*;

/**
 * 某个班级80名学生，现在需要组织秋游活动，班长提供了四个景点依次是（A、B、C、D）,
 * 每个学生只能选择一个景点，请统计出最终哪个景点想去的人数最多。
 */
public class Question04 {
    public static void main(String[] args) {
        Random random = new Random();
        int num = 0;
        Character[] characters = new Character[80];

        for (int i = 0; i < 80; i++) {
            num = random.nextInt(4) + 65;
            characters[i] = (char) num;
        }
        System.out.println(Arrays.toString(characters));
        System.out.println(characters.length);
        HashMap<String, Integer> map = new HashMap<>();
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (Character character : characters) {
            if (character.equals('A')) {
                map.put("A", ++a);
            } else if (character.equals('B')) {
                map.put("B", ++b);
            } else if (character.equals('C')) {
                map.put("C", ++c);
            } else if (character.equals('D')) {
                map.put("D", ++d);
            }
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.print("地点" + entry.getKey() + " 人数：" + entry.getValue() + "\n");
        }
    }
}
