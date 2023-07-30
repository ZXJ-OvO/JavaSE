package com.zxj.day17;

import java.io.File;

/**
 * 1、需要使用到递归算法，遍历文件夹中所有的文件
 * 2、控制台输出内容对齐可以调用padRight方法通过不全字符的方式进行实现，用户查看体验好
 */
public class Question18 {
    public static void main(String[] args) {

        // 遍历指定路径下的所有文件对象

        File file = new File("C:\\Users\\root\\Desktop\\day08-Stream、File、方法递归、字符集");
        printFile(file);


    }

    private static void printFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printFile(f);
                }
            }
        } else {
            System.out.println(padRight(file.getName(), 50, ' ') + file.length());
        }
    }

    public static String padRight(String origin, int length, char ch) {
        StringBuilder originBuilder = new StringBuilder(origin);
        while (originBuilder.length() < length) {
            originBuilder.append(ch);
        }
        origin = originBuilder.toString();
        return origin;
    }
}
