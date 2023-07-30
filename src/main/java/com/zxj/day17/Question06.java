package com.zxj.day17;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.text.StrSplitter;

import java.io.File;

/**
 * 遍历文件夹修改文件名
 */
public class Question06 {
    public static void main(String[] args) {
        File day02 = new File("C:\\Users\\root\\Desktop\\new\\day02-面向对象高级部分\\视频");

        File[] day02Files = day02.listFiles();

        if (day02Files != null) {
            for (File day02File : day02Files) {
                String currentName = day02File.getName();
                String[] strings = StrSplitter.splitToArray(currentName, "、", 0, true, true);
                String id = strings[0];
                Integer intId = Convert.toInt(id);
                intId += 20;
                String newIdStr = Convert.toStr(intId);
                strings[0] = newIdStr;
                String newName = newIdStr + "、" + strings[1];
                System.out.println(newName);
                day02File.renameTo(new File(day02, newName));
            }
        }
    }
}