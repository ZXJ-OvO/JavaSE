package com.zxj.day18;

import java.io.File;

/**
 * 1 byte = 8 bit
 * 1 KB = 1024 byte
 * 1 MB = 1024 KB
 * 1 GB = 1024 MB
 * 1 TB = 1024 GB
 * 1 PB = 1024 TB
 * 1 EB = 1024 PB
 * 1 ZB = 1024 EB
 * 1 YB = 1024 ZB
 * 1 BB = 1024 YB
 * 1 NB = 1024 BB
 * 1 DB = 1024 NB
 * 1 CB = 1024 DB
 * 1 XB = 1024 CB
 * 1 WB = 1024 XB
 * 1 VB = 1024 WB
 * 1 UB = 1024 VB
 * 1 OB = 1024 UB
 * 1 IB = 1024 OB
 * 1 B = 1024 IB
 */
public class Question05 {
    public static void main(String[] args) {

        // File 指向文件
        File file1 = new File("D:\\project\\java\\JavaSE\\JavaSE\\JavaSE\\src\\main\\resources\\JavaSE疑难杂症.pptx");
        File file2 = new File("D:\\project\\java\\JavaSE\\JavaSE\\JavaSE\\src\\main\\resources\\JavaSE疑难杂症.pptx");

        // 文件分隔符可以使用跨平台的File.separator，它可以根据不同的操作系统，返回不同的文件分隔符
        File file3 = new File("D:" + File.separator + "project" + File.separator + "java" +
                File.separator + "JavaSE" + File.separator + "JavaSE" +
                File.separator + "JavaSE" + File.separator + "src" +
                File.separator + "main" + File.separator + "resources"
                + File.separator + "JavaSE疑难杂症.pptx");

        System.out.println("文件大小：" + file1.length() + "字节");
        System.out.println(file2);
        System.out.println("文件大小：" + file3.length() / 1024.0 / 1024.0 + "MB");

        System.out.println("---------------------------------------------------------------------------");

        // File 指向文件夹   可以指向一个空的文件夹
        File file4 = new File("D:" + File.separator + "my.cnf");
        // 不管存在不存在，直接打印输出都可得到路径
        System.out.println(file4);  // D:\my.cnf
        System.out.println(file4.exists());  // false
        System.out.println(file4.length());  // 0

        System.out.println("---------------------------------------------------------------------------");

        // 绝对路径
        File file5 = new File("D:\\project\\java\\JavaSE\\JavaSE\\JavaSE\\src\\main\\java\\com\\zxj\\day18\\Question05.java");

        // 相对路径
        File file6 = new File("JavaSE\\JavaSE\\src\\a.txt");
        System.out.println(file6.length());
    }
}
