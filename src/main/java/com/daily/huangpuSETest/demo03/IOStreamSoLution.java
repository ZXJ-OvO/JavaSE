package com.daily.huangpuSETest.demo03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * **需求**
 * * 黑马程序员教学管理系统的菜单信息如下（图1所示），菜单的详细数据存储在**给的素材文件“系统菜单.txt”中**。
 * **具体要实现的功能点如下所示**
 * 1、请从**系统菜单.txt**中读取这些菜单信息，将这些菜单信息在控制台展示成图1的样子（必须确保展示的顺序是正确的）
 * 2、将正确的菜单顺序，写出到一个新文件**"系统菜单2.txt"**中保存起来，详细格式如下
 */
public class IOStreamSoLution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\java\\com\\daily\\huangpuSETest\\demo03\\系统菜单.txt"));
             PrintStream printStream = new PrintStream("src\\main\\java\\com\\daily\\huangpuSETest\\demo03\\系统菜单2.txt")) {

            ArrayList<String> strings = new ArrayList<>();
            String s;
            while ((s = bufferedReader.readLine()) != null) strings.add(s);
            Collections.sort(strings);

            for (String string : strings) printStream.println(string);
            System.out.println("复制完成！");
        }
    }
}
