package com.zxj.day19;

import java.io.FileReader;

/**
 * 文件字符输入流：每次读取多个字符
 */
public class Question02 {
    public static void main(String[] args) {
        try (
                FileReader reader = new FileReader("src/main/resources/test.txt");
        ) {
            char[] chars = new char[3];
            int len;
            while ((len = reader.read(chars)) != -1) {
                // 使用String的构造器将其转化成字符串格式
                System.out.print(new String(chars, 0, len));
            }
            // 性能是比较不错的
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
