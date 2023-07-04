package com.zxj.day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制
 */
public class Question14 {
    public static void main(String[] args) throws Exception {
        // try with resources 自动释放资源，调用资源对象的close方法，小括号只能存放资源对象（即最终实现了AutoCloseable接口）
        try (
                // 建立管道
                FileInputStream inputStream = new FileInputStream("src/main/resources/test.txt");
                FileOutputStream outputStream = new FileOutputStream("src/main/resources/ss/test.txt", true);  // 需要手动填写目标地址文件而不是文件夹
        ) {
            byte[] bytes = new byte[1024];   // 1kb

            outputStream.write("\r\n".getBytes());  // 换行

            int len;    // 记住读到了多少个字节
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
