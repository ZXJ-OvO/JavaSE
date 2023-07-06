package com.zxj.day19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 字符缓冲流
 */
public class Question05 {
    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/test.txt"));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/aa/tt/test.txt"));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
