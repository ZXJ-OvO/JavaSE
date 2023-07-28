package com.zxj.day18;

import java.io.FileReader;

public class Question20 {
    public static void main(String[] args) throws Exception {
        try (FileReader reader = new FileReader("src/main/resources/test.txt")
        ) {
//            int c; // 记录每次读取的字符编号
//            // 每次读取一个字符
//            while ((c = reader.read()) != -1) {
//                System.out.println((char) c);
//            }

            char[] chars = new char[3];
            int len; // 记录每次读取了多少个字符
            while ((len = reader.read(chars)) != -1){
                String s = new String(chars, 0, len);
                System.out.print(s);
            }
        }
    }
}
