package com.zxj.day18;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 打印流
 */
public class Question29 {
    public static void main(String[] args) {
        try (
                FileReader fileReader = new FileReader("src/main/resources/test.txt");
                BufferedReader ignored = new BufferedReader(fileReader);
                FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/test11.txt", true);
                PrintStream printStream = new PrintStream(fileOutputStream)) {
            while (true) {
                printStream.println(new Scanner(System.in).nextLine());
            }
     /*       String s;
            while ((s = bufferedReader.readLine()) != null) {
                printStream.println(s);
            }*/


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
