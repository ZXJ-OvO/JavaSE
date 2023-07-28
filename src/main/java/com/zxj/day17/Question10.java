package com.zxj.day17;

import java.io.File;
import java.io.IOException;

/**
 * 遍历文件夹搜索文件夹
 */
public class Question10 {
    public static void main(String[] args) throws IOException {
        File dir = new File("C:/");
        searchFile(dir, "cmd.exe");
    }

    /**
     * 文件搜索
     *
     * @param dir      需要遍历查询的目录
     * @param fileName 需要查询的目标文件
     */
    private static void searchFile(File dir, String fileName) throws IOException {
        // 1. 判断参数的合法性
        if (dir == null || fileName == null || !dir.exists() || dir.isFile()) {
            return;
        }

        // 2、提取全部的一级文件对象数组
        File[] files = dir.listFiles();

        // 3、判断是否存在一级文件对象
        if (files == null) {
            return;
        }

        // 4、遍历一级文件对象
        for (File file : files) {
            // 5、判断file是否是文件
            if (file.isFile()) {
                if (file.getName().contains((fileName))) {
                    System.out.println("找到该文件：" + file.getAbsolutePath());
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec(file.getAbsolutePath());
                }
            } else {
                // 遍历到文件夹，继续进入到这个文件夹递归寻找
                searchFile(file, fileName);
            }
        }
    }
}
