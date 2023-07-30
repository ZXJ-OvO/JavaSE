package com.zxj.day18;

import java.io.*;

/**
 * 字符转换流
 */
public class Question28 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("src/main/resources/test.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/test11.txt");
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream)
        ) {

            int read;
            while ((read = inputStreamReader.read()) != -1) {
                outputStreamWriter.write((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
