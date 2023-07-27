package com.zxj.day18;

import java.io.FileInputStream;

public class Question17 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("src/main/resources/test.txt");
        byte[] bytes = inputStream.readAllBytes();        // Since 9 readAllBytes()
        System.out.println(new String(bytes));

        FileInputStream inputStream1 = new FileInputStream("src/main/resources/test.txt");
        byte[] bytes1 = inputStream1.readAllBytes();
        System.out.println(new String(bytes1));

        FileInputStream inputStream2 = new FileInputStream("pathname");
        byte[] bytes2 = inputStream2.readAllBytes();
        System.out.println(new String(bytes2));

        FileInputStream inputStream3 = new FileInputStream("pathName");
        byte[] bytes3 = inputStream3.readAllBytes();
        System.out.println(new String(bytes3));

//        int read = inputStream.read();
//        System.out.println((char) read);
//
//        int read1 = inputStream.read();
//        System.out.println((char) read1);

        // 用来记住每次读取到的一个字节
//        int b;
//        while ((b = inputStream.read()) != -1) {
//            // 自带换行，不要手动换行
//            System.out.print((char) b);
//        }

        // 设置IO的桶，代表每次桶会读取3个字节

//        byte[] buffer = new byte[(int) file.length()];

        // 最后一桶可能读不满，记录每次读取的数量
//        int len;
//        //
//        while ((len = inputStream.read(buffer)) != -1) {
//            // 读取多少，倒出多少
//            String s = new String(buffer, 0, len);
//            System.out.print(s);
//        }

//        inputStream.read(buffer);
//        // 读取多少，倒出多少
//        String s = new String(buffer);
//        System.out.print(s);


//
//        int read = inputStream.read(buffer);
//        System.out.println("读取了多少个字节 " + read);
//
//        String s = new String(buffer);
//        System.out.println("读取的内容 " + s);

    }
}
