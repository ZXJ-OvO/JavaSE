package com.zxj.day18;


import java.io.FileInputStream;
import java.io.InputStream;

public class Question11 {
    public static void main(String[] args) throws Exception {

        // 1. 创建文件字节输入流管道，与源文件接通
        InputStream fileInputStream = new FileInputStream("src/main/resources/test.text");

        // 2. 每次读取一个字节
/*        int read1 = fileInputStream.read();
        System.out.println((char) read1);

        int read2 = fileInputStream.read();
        System.out.println((char) read2);*/

        // 3. 循环读取
        int read;
        while ((read = fileInputStream.read()) != -1) {
            System.out.print((char) read);
        }

        // 1. 性能很差
        // 2. 造成中文乱码且无法避免

        // IO底层和硬件资源关联，使用完后必须手动关闭
        fileInputStream.close();
    }
}
