package com.zxj.day18;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 模拟歌曲复制和删除过程：假设在D：\\songs文件夹中存在一些歌曲(歌曲文件，可以为txt格式，)
 * 循环显示该菜单：请选择您要进行的操作：1：查询所有歌曲   2：根据歌曲名称复制  3：根据歌曲名称删除 4: 退出
 * 举例：
 * 用户输入：1
 * 存在以下歌曲：
 * 蒙娜丽莎的眼泪
 * 烟花易冷
 * 上海滩
 * 小苹果
 * 夜空中最亮的星
 * 用户输入：2
 * 请输入要复制的歌曲名称: 上海滩
 * 请输入存储路径: E:\\songs  (说明:该路径如果存在则不创建,不存在则创建)
 * 复制结果: 歌曲上海滩已经成功复制到E:\\songs目录中
 * 用户输入：3
 * 请输入要删除的歌曲名称: 上海滩
 * 删除结果: 歌曲上海滩已经成功删除
 * 用户输入: 4
 * 退出系统
 */
public class Question33 {
    private static final File filePath = new File("C:\\Users\\root\\Desktop\\壁纸");

    public static void main(String[] args) throws Exception {
        showMenu(null);
    }

    public static void showMenu(FileInputStream fileInputStream) {
        while (true) {
            System.out.println("请选择您要进行的操作：1：查询所有歌曲   2：根据歌曲名称复制  3：根据歌曲名称删除 4: 退出");

            String s = new Scanner(System.in).nextLine();
            Integer cmd = Convert.toInt(s);

            switch (cmd) {
                case 1:
                    listAllSongs(fileInputStream);
                    break;
                case 2:
                    copyBySongName(fileInputStream);
                    break;
                case 3:
                    deleteBySongName(fileInputStream);
                    break;
                case 4:
                    System.out.println("退出系统");
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }

    private static void deleteBySongName(FileInputStream fileInputStream) {
        System.out.println("请输入要删除的图片名称: ");
        String img = new Scanner(System.in).nextLine();
        if (!new File(filePath, img).exists()) {
            System.out.println("图片不存在");
            return;
        }
        FileUtil.del(new File(filePath, img));
        System.out.println("删除成功！");

    }

    private static void copyBySongName(FileInputStream fileInputStream) {
        System.out.println("请输入要复制的图片名称: ");
        String img = new Scanner(System.in).nextLine();
        if (!new File(filePath, img).exists()) {
            System.out.println("图片不存在");
            return;
        }

        System.out.println("请输入存储路径: ");
        String path = new Scanner(System.in).nextLine();
        if (!new File(path).exists()) {
            System.out.println("路径不存在");
            return;
        }

        FileUtil.copy(new File(filePath, img), new File(path), true);
        System.out.println("复制成功！");

    }

    private static void listAllSongs(FileInputStream fileInputStream) {
        System.out.println("存在以下图片：");
        File[] files = filePath.listFiles();
        for (File file : files) {
            String name = file.getName();
            if (name.substring(name.lastIndexOf(".")).equals(".jpg")) System.out.println(name);
        }
    }
}
