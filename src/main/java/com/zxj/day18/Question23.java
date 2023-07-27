package com.zxj.day18;


import com.zxj.day23.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;

public class Question23 {
    public static void main(String[] args) throws Exception {

        try (FileReader fileReader = new FileReader("src/main/resources/test.txt");
             FileWriter fileWriter = new FileWriter("src/main/resources/test1.txt");

             BufferedReader bufferedReader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            String line;
            ArrayList<String> list = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            Collections.sort(list);

            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        }
    }
}
