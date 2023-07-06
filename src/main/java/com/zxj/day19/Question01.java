package com.zxj.day19;

import java.io.FileReader;
import java.io.Reader;

/**
 * 文件字符输入流：每次读取一个字符
 */
public class Question01 {
    public static void main(String[] args) {

        try (
                // 1.创建一个文件字符输入流管道与源文件接通
                Reader reader = new FileReader("src/main/resources/test.txt");
        ) {
            // 读取文本文件的内容
            int c;  // 记住每次读取的字符编号
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            // 每次读取一个字符的形式，性能肯定是很弱的
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
