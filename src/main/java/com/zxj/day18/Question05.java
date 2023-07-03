package com.zxj.day18;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

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

        // 相对路径 以src为参照点
        File file6 = new File("src\\main\\resources\\a.txt");
        System.out.println(file6.length());

        System.out.println("---------------------------------------------------------------------------");
        File file = new File("src\\main\\resources\\a.txt");
        System.out.println(file.exists());  // 用于判断文件是否存在

        System.out.println(file.isFile());  // 用于判断是否是文件

        System.out.println(file.isDirectory());  // 用于判断是否是文件夹

        System.out.println(file.getName());  // 用于获取文件名

        System.out.println(file.length());  // 用于获取文件大小

        System.out.println(file.lastModified()); // 用于获取文件最后修改时间

        String formatted = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified());
        System.out.println(formatted);

        System.out.println(file.getPath());  // 用于获取创建文件时得到的文件路径，创建时使用的是相对路径就获取相对路径，使用的是绝对路径就获取绝对路径

        System.out.println(file.getAbsolutePath());  // 用于获取文件绝对路径

        System.out.println("---------------------------------------------------------------------------");

        File file7 = new File("src/main/resources/b.txt");
        try {
            System.out.println(file7.createNewFile());  // 用于创建文件，如果文件已存在则返回false
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File file8 = new File("src/main/resources/c");
        file8.mkdir();  // 用于创建文件夹，如果文件夹已存在则返回false只能创建一级目录文件夹
        File file9 = new File("src/main/resources/d/e/f");
        System.out.println(file9.mkdirs()); // 用于创建多级文件夹，如果文件夹已存在则返回false可以创建多级目录文件夹

        System.out.println(file7.delete());  // 用于删除文件和非空文件夹，如果文件不存在则返回false
    }
}
