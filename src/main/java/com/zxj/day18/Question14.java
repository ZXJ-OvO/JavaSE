package com.zxj.day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 文件复制
 */
public class Question14 {
    public static void main(String[] args) throws Exception {
        // 建立管道
        FileInputStream inputStream = new FileInputStream("src/main/resources/test.txt");
        FileOutputStream outputStream = new FileOutputStream("src/main/resources/ss/test.txt", true);  // 需要手动填写目标地址文件而不是文件夹

        byte[] bytes = new byte[1024];   // 1kb

        outputStream.write("\r\n".getBytes());  // 换行

        int len;    // 记住读到了多少个字节
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }

        // 按照出栈的顺序关闭流
        outputStream.close();
        inputStream.close();
    }
}
