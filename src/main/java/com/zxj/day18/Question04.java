package com.zxj.day18;

import java.io.File;

/**
 * 需求：从D:盘中，搜索“QQ.exe” 这个文件，找到后直接输出其位置。
 * 分析：
 * 先找出D:盘下的所有一级文件对象
 * 遍历全部一级文件对象，判断是否是文件
 * 如果是文件，判断是否是自己想要的
 * 如果是文件夹，需要继续进入到该文件夹，重复上述过程
 */
public class Question04 {
    public static void main(String[] args) {
        File file = new File("D:\\");
        findFile(file);
    }

    public static String findFile(File file) {
        File[] files = file.listFiles();
        if (files.length == 0) {
            return null;
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                if (files[i].getName().equals("QQ.exe")) {
                    // todo 打印绝对路径
                } else {
                    continue;
                }
            }
            if (files[i].isDirectory()) {
                // todo 进入到文件夹中
                // todo 递归本方法
            }
        }
        return null;
    }
}
