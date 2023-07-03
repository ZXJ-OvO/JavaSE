package com.zxj.day18;

import java.io.File;
import java.util.Arrays;

/**
 * 遍历文件夹
 */
public class Question06 {
    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "software");
        String[] list = file.list(); // 获取当前目录下的所有文件和文件夹的名称
        System.out.println(Arrays.toString(list));

        File[] files = file.listFiles(); // 获取当前目录下的所有文件和文件夹的对象
        System.out.println(Arrays.toString(files));

        File file1 = new File("src/main/resources/b.txt");
        System.out.println(file1.listFiles()); // 当主调文件对象不是文件夹时，返回null

        // 当主调文件对象是一个没有权限访问的文件夹时，返回null

        File file2 = new File("src/main/resources/c");
        System.out.println(Arrays.toString(file2.listFiles())); // 当主调文件对象是空文件夹时,返回空数组

        // 当主调文件对象是一个有内容且包含隐藏文件的文件夹时，返回所有文件对象，包括隐藏文件

        // 当主调文件对象是一个有内容的文件夹时，将里面所有一级文件和文件夹的路径放在Files数组中返回
    }
}
