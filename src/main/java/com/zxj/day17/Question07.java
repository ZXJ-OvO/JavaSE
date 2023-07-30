package com.zxj.day17;

import java.io.File;

public class Question07 {
    public static void main(String[] args) {
        // 目标：掌握File对象的创建，来代表具体的文件。

        // 1、创建File对象
        File file = new File("E:/resource/aaa.png");
        // File f1 = new File("E:" + File.separator + "resource" + File.separator + "aaa.png");


        // 2、File对象可以代表文件，也可以代表文件夹。
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        // 3、File对象代表的文件路径可以是不存在的
        System.out.println(file.exists());

        // 4、File对象的路径可以支持绝对路径，相对路径。
        // 什么是绝对路径？ 从磁盘的根路径开始一路寻找的路径。

        // 什么是相对路径？ （重点）
        // 默认相对到当前工程下寻找文件的。
        // 说白了不带盘符，直接到project（工程）下找文件
        // 相对路径一般是用于找模块中的文件的。
        File f5 = new File("day08-stream-file-io\\src\\dlei01.txt");
        System.out.println(f5.length());
    }
}
