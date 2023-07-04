package com.zxj.day18;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Java在Windows平台下的换行符为\n   建议使用兼容性更广的换行符\r\n
 */
public class Question13 {
    public static void main(String[] args) throws Exception {

        System.out.println("-----------------------------------------------------重写数据");
        // 1. 创建一个字节输出流管道与目标接通
        // OutputStream fileOutputStream = new FileOutputStream("src/main/resources/test.txt");


        System.out.println("------------------------------------------------------追加数据");
        OutputStream fileOutputStream = new FileOutputStream("src/main/resources/test.txt", true);

        // 2. 开始写字节数据出去
//        fileOutputStream.write(97);  // 97 代表一个字节，a
//        fileOutputStream.write('b');    // 字符b是一个数字98同时也是一个字节
//        fileOutputStream.write('美');    // 单个汉字作为字符是可以传递的，但是汉字由3个字节组成，而默认只能写出一个字节，最终导致乱码

        // 一次性写出多个字符
        String s = "我爱你美国";
        byte[] bytes = s.getBytes();
        fileOutputStream.write(bytes);

        // 写一个数据的一部分
        fileOutputStream.write(bytes, 0, 15);

        // 写一个换行符  \r\n
        fileOutputStream.write("\r\n".getBytes());

        fileOutputStream.write(bytes, 0, 15);



        fileOutputStream.close();
    }
}
