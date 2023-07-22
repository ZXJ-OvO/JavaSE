package com.zxj.day16;

import java.util.HashSet;
import java.util.Iterator;

/**
 * (1)定义Set集合，存入多个字符串
 * (2)删除集合中不满足身份证号码的数据
 * 身份证要求：
 * - 长度必须18位
 * - 数字0不能开头
 * - 除了最后一位，中间不允许有字母
 * - 最后一位可以是数字或者Xx
 * (3)然后利用迭代器遍历集合元素并输出
 */
public class Question23 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("123456789012345678");
        hashSet.add("12345678901234567X");
        hashSet.add("12345678901234567x");
        hashSet.add("12345678901234567");
        for (String s : hashSet) {
            System.out.println(s);
        }

        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();

            if (s.length() != 18) {
                iterator.remove();
                continue;
            }
            if (s.charAt(0) == '0') {
                iterator.remove();
                continue;
            }
            if (s.matches(".*[a-zA-Z]+.*")) {
                iterator.remove();

                continue;
            }
            if (s.charAt(17) != 'X' && s.charAt(17) != 'x' && !Character.isDigit(s.charAt(17))) {
                iterator.remove();
                continue;
            }
            System.out.println(s);

        }


        for (String s : hashSet) {
            System.out.println(s);
        }
    }
}
