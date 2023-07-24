package com.zxj.day17;

import java.io.File;
import java.io.IOException;

public class Question09 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\project\\java\\JavaSE\\JavaSE\\src\\main\\resources\\newFile");

        // 1、public boolean createNewFile()：创建一个新文件（文件内容为空），创建成功返回true,反之。
        System.out.println(file.createNewFile());

        // 2、public boolean mkdir()：用于创建文件夹，注意：只能创建一级文件夹
        System.out.println(file.mkdir());

        // 3、public boolean mkdirs()(重点)：用于创建文件夹，注意：可以创建多级文件夹
        File file1 = new File("D:\\project\\java\\JavaSE\\JavaSE\\src\\main\\resources\\newFile1\\newFile1\\newFile1");
        System.out.println(file1.mkdirs());

        // 4、public boolean delete()：删除文件，或者空文件，注意：不能删除非空文件夹。

        System.out.println(file1.delete());

    }
}
