package com.zxj.day19;

import java.io.*;

/**
 * 字节缓冲流：包装原始流后自带8kb的缓冲池
 */
public class Question04 {
    public static void main(String[] args) {
        try (
                InputStream inputStream = new FileInputStream("src/main/resources/test.txt");
                InputStream bufferedInputStream = new BufferedInputStream(inputStream);
                OutputStream outputStream = new FileOutputStream("src/main/resources/aa/tt/test.txt");
                OutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
