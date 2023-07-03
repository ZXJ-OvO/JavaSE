package com.zxj.day18;

import java.io.File;

/**
 * 删除指定的包含内容的文件夹
 */
public class Question08 {
    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "test");
        deleteDirectories(file);
    }

    public static void deleteDirectories(File dir) {
        // 拦截非法情况：传入的不是文件夹  文件夹下为空  文件夹不存在
        if (dir == null || !dir.exists()) return;

        if (dir.isFile()) {
            dir.delete();
            return;
        }

        // file存在且是一级文件夹
        File[] files = dir.listFiles();

        // 没有权限
        if (files == null) return;

        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            } else {
                deleteDirectories(file);
            }
        }
        dir.delete();
    }
}
