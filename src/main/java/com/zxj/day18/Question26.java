package com.zxj.day18;

import java.io.*;

/**
 * 复制一个文件路径中的所有内容到另一个文件路径下  使用HuTool工具类
 * FileUtil.copy(filePath, targetPath, true);
 * 文件复制的同时，在控制台显示文件复制的进度，进度以百分比表示。
 * DecimalFormat df = new DecimalFormat("##%");
 * String format = df.format(3.0 / 10);
 * System.out.println(format);  // 30%
 * IO流不能操作文件夹
 */
public class Question26 {
    public static void main(String[] args) throws Exception {
        String s1 = "C:\\Users\\root\\Desktop\\new\\aaa";
        String s2 = "C:\\Users\\root\\Desktop\\new\\bbb";
        copyFolder(new File(s1), new File(s2));
        System.out.println("文件复制完成！");
    }

    public static void copyFolder(File source, File target) throws Exception {
        // 判断是否是文件夹
        if (source.isDirectory()) {
            // 是文件夹

            // 如果目标文件夹不存在就创建文件夹
            if (!target.exists()) target.mkdirs();

            // 获取当前路径目录下的所有一级文件名称
            String[] files = source.list();

            // 判断当前拿到的一级文件名称数组是否为空
            if (files != null) {
                // 拿到文件名称数组的长度即当前路径下有多少一级文件
                int totalFiles = files.length;
                // 复制操作计数器
                int copiedFiles = 0;
                for (String file : files) {
                    // 根据源文件路径和源文件名称创建文件对象
                    File srcFile = new File(source, file);
                    // 根据目标文件路径和目标文件名称创建对象
                    File destFile = new File(target, file);

                    // 递归
                    copyFolder(srcFile, destFile);

                    // 复制操作计数器加一
                    copiedFiles++;
                    // 计算并打印复制进度
                    double progress = (double) copiedFiles / totalFiles * 100;
                    //   System.out.println(progress);
                    System.out.printf("\r复制进度：%.2f%%", progress);
                }
            }
        } else {
            try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(target);) {

                byte[] buffer = new byte[1024 * 64];
                int bytesRead;
                long totalBytes = source.length();
                long copiedBytes = 0;

                while ((bytesRead = in.read(buffer)) > 0) {
                    out.write(buffer, 0, bytesRead);
                    copiedBytes += bytesRead;
                    // 计算并打印复制进度
                    double progress = (double) copiedBytes / totalBytes * 100;
                    System.out.printf("\r复制进度：%.2f%%", progress);
                }
            }
        }
    }
}
