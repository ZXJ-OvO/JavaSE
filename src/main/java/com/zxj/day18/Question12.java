package com.zxj.day18;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Question12 {
    public static void main(String[] args) throws Exception {
        File file = new File("src/main/resources/test.text");
        //    InputStream stream = new FileInputStream(file);
        InputStream stream = new FileInputStream("src/main/resources/test.text");

/*        // 创建字节数组用于装数据
        byte[] bytes = new byte[3];
        // 使用字节输入流从文件中读取指定字节数组长度的字节数据
        // stream中的数据通过read方法，一次读取byte[]长度的字节数据，并返回读取的数据的个数
        int len = stream.read(bytes);
        // 将字节数据使用平台默认编码方式进行解码

        String s = new String(bytes);
        System.out.println(s);
        System.out.println("单次读取的字节数量：" + len);

        // 在新一轮读取到的数据会覆盖原来字节数组中的数据，旧数据被撤走，新数据按顺序占据原来的位置，但是当最后依次读取的数据的个数小于字节数组的长度时，没有被覆盖的位置会保留旧数据
        int i = stream.read(bytes);
        String s1 = new String(bytes, 0, i);  // 读多少倒多少，从0开始读，读到i
        System.out.println(s1);
        System.out.println(i);

        int read = stream.read(bytes);
        System.out.println(read); // -1 没有数据供读取*/

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
