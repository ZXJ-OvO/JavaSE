package com.zxj.day18;


import java.io.FileInputStream;
import java.io.InputStream;

public class Question12 {
    public static void main(String[] args) throws Exception {
        //    InputStream stream = new FileInputStream(file);
        InputStream stream = new FileInputStream("src/main/resources/test.text");

// 通过控制桶大小与文件大小相同实现防止中文乱码问题
//        long length = file.length();
//        System.out.println(length);
//
//        byte[] buffer = new byte[(int) length];
//        int len; // 记住每次读取了多少字节
//        while ((len = stream.read(buffer)) != -1) {
//            String s = new String(buffer, 0, len);
//            System.out.print(s);
//        }

        // 性能得到了明显的提升
        // 仍然无法避免乱码问题

        // JDK9起提供的方法InputStream.readAllBytes：效果同上
        // 但是早期的readAllBytes没有考虑到本地数组装不了太大文件的问题，从JDK11开始进行大文件校验，过大的文件直接抛出内存溢出异常
        // byte[] buffer = is.readAllBytes();


        stream.close();

    }
}
