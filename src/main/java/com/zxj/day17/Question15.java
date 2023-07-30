package com.zxj.day17;

import java.io.File;
import java.util.Scanner;

/**
 * 1. 键盘录入一个新文件夹路径判断该路径是否存在
 * - 如果存在，则什么都不做
 * - 如果不存在，则创建该文件夹
 * 2. 键盘录入一个路径，并将该路径指向的文件或文件夹删除；【别瞎玩】
 * 3. 获得指定文件夹下所有的java文件(不考虑子文件夹的)并输出到控制台
 * 4. 统计任意一个文件夹的大小 （length()方法可以获取文件的大小）
 * 5. 键盘录入一个路径，将指定路径下的小于200K的小文件，并打印
 */
public class Question15 {
    public static void main(String[] args) {

        System.out.println("\"键盘录入一个路径，将指定路径下的小于200K的小文件，并打印\"");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        File file2 = new File(next);
        File[] files1 = file2.listFiles();
        if (files1 != null) {
            for (File file3 : files1) {
                if (file3.length() < 200) {
                    System.out.println(file3.getName());
                }
            }
        }
    }
}
