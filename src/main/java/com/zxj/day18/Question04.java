package com.zxj.day18;

import java.io.File;
import java.io.IOException;

/**
 * 需求：从D:盘中，搜索“QQ.exe” 这个文件，找到后直接输出其位置。
 * 分析：
 * 先找出D:盘下的所有一级文件对象
 * 遍历全部一级文件对象，判断是否是文件
 * 如果是文件，判断是否是自己想要的
 * 如果是文件夹，需要继续进入到该文件夹，重复上述过程
 */
public class Question04 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\");
        findFile(file, "Java API Crib Sheet.md");
    }

    public static void findFile(File file, String fileName) {
        // 拦截非法情况：传入的file是空的，不存在的，不是文件夹的
        if (file == null || file.isFile() || !file.exists()) System.out.println("the file is invalid");

        // 拿到当前文件对象下的所有一级文件对象
        File[] files = new File[0];
        if (file != null) {
            files = file.listFiles();
        }

        // 拦截文件对象中的非法情况：不存在子文件、文件访问权限不足
        if (files != null) {
            // 遍历文件夹
            for (File f : files) {
                // 判断是文件还是文件夹，文件夹需要递归遍历，文件需要判断

                // 文件
                if (f.isFile()) if (f.getName().contains(fileName)) {
                    System.out.println(f.getAbsolutePath());
//                    Runtime runtime = Runtime.getRuntime();
//                    runtime.exec(f.getAbsolutePath());
                }

                // 文件夹
                if (f.isDirectory()) {
                    findFile(f, fileName);
                }
            }
        }
    }
}