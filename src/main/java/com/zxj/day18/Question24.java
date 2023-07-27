package com.zxj.day18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Question24 {
    public static void main(String[] args) throws Exception {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/main/resources/test.txt")); BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/main/resources/test1.txt"));) {
            byte[] bytes = bufferedInputStream.readAllBytes();
            String string = new String(bytes);
            String reverse = new StringBuilder(string).reverse().toString();
            bufferedOutputStream.write(reverse.getBytes());
        }
    }
}
