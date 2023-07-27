package com.zxj.day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Question19 {
    public static void main(String[] args) throws Exception {
        try (FileInputStream inputStream = new FileInputStream("src/main/resources/test.txt");
             FileOutputStream outputStream = new FileOutputStream("src/main/resources/copy.txt", true)
        ) {
            byte[] bytes = inputStream.readAllBytes();
            outputStream.write(bytes);
        }
    }
}