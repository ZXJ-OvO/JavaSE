package com.zxj.day18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 需求：将某个磁盘的文件夹拷贝到另一个文件夹下去，包括文件夹中的全部信息
 * 分析：
 * ①：IO默认不可以拷贝文件夹
 * ②：我们需要遍历文件夹，如果是文件则拷贝过去，如果是文件夹则要进行1-1创建，继续复制内容
 */
public class Question15 {
    public static void main(String[] args) throws Exception {
        // 源文件夹地址
        File sourceAddress = new File("src/main/resources/ss");
        // 目标文件夹地址
        File targetAddress = new File("src/main/resources/aa");

        copyFolder(sourceAddress, targetAddress);
        System.out.println("拷贝完成");
    }

    public static void copyFolder(File sourceAddress, File targetAddress) throws Exception {
        if (!sourceAddress.exists()) {
            System.out.println("源文件夹不存在");
            return;
        }

        // 在后续的操作中，开始递归到文件夹对象的时候，先判断目标文件夹是否存在，不存在则创建
        if (!targetAddress.exists()) {
            // mkdirs() 创建多级文件夹
            targetAddress.mkdirs();
        }

        if (sourceAddress.isFile()) {
            // 是文件直接拷贝
            copyFile(sourceAddress, new File(targetAddress, sourceAddress.getName()));
        } else if (sourceAddress.isDirectory()) {

            File[] files = sourceAddress.listFiles();
            if (files != null) {
                for (File file : files) {
                    // new File(parentAddress, childAddress) 根据父路径和子路径拼接成一个路径创建文件
                    copyFolder(file, new File(targetAddress, file.getName()));
                }
            }
        }
    }

    public static void copyFile(File sourceFile, File targetFile) {
        try (FileInputStream inputStream = new FileInputStream(sourceFile); FileOutputStream outputStream = new FileOutputStream(targetFile);) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
