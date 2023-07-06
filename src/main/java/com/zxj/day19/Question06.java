package com.zxj.day19;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 复制txt的内容到另一个txt中
 */
public class Question06 {
    public static void main(String[] args) {
        String SourcePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "test.txt";
        String targetPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "aa" + File.separator + "tt" + File.separator + "test.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(SourcePath));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetPath));
        ) {
            // 目标 恢复顺序并复制到另一个文件中

            // 1、定义一个ArrayList集合存储每段的内容
            ArrayList<String> data = new ArrayList<>();

            // 2、读取文件内容

            // 3、按照行读取每段
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line);
            }

            // 4、排序
            Collections.sort(data);     // Collections工具类的sort方法可以根据首个字符的Unicode码进行排序
            System.out.println(data);

            // 5、遍历集合中的每段内容，依次写入文件中
            for (String datum : data) {
                bufferedWriter.write(datum); // 字符缓冲写入流可以直接写入字符串
                bufferedWriter.newLine();   // 换行
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
