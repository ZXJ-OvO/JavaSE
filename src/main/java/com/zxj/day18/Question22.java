package com.zxj.day18;

import java.io.*;

public class Question22 {
    public static void main(String[] args) throws Exception {

        try (
                // 包装字节缓冲输入流
                InputStream inputStream = new FileInputStream("C:\\Users\\root\\Desktop\\壁纸\\aaa.jpg");
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

                // 包装字节缓冲输出流
                FileOutputStream outputStream = new FileOutputStream("C:\\Users\\root\\Desktop\\壁纸\\aaa2.jpg");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

                // 包装字符缓冲输入流
                FileReader reader = new FileReader("src/main/resources/test.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);

                // 包装字符缓冲输出流
                FileWriter writer = new FileWriter("src/main/resources/test1.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(writer)
        ) {
            // 高级字节流读写操作
            byte[] bytes = bufferedInputStream.readAllBytes();
            bufferedOutputStream.write(bytes);

            // 高级字符流读写操作
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }
}
