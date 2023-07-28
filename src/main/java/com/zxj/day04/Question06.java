package com.zxj.day04;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * 某公司开发部5名开发人员，要进行项目进展汇报演讲，现在采取随机排名后进行汇报。
 * 请先依次录入5名员工的工号，然后展示出一组随机排名顺序。
 */
public class Question06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入5名员工的工号：");
        String[] array = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("请输入第" + (i + 1) + "名员工的工号：");
            array[i] = in.nextLine();
        }

        // 分析：如果要实现随机排名，就要实现随机数的去重，代码量繁重，不推荐
        // 优化：使用Map集合，key存储工号，value存储随机数，随机数不重复
        Map<String, Integer> map = new HashMap<>();
        Random random = new Random();
        for (String s : array) {
            int num;
            do {
                num = random.nextInt(5) + 1;
            } while (map.containsValue(num)); //containsValue()方法用于判断Map集合中是否包含指定的值
            map.put(s, num);
        }
        // 遍历Map集合
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "的随机数为：" + entry.getValue());
        }
    }
}
