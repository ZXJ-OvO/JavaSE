package com.zxj.day18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 数据流
 */
public class Question30 {
    public static void main(String[] args) throws Exception {
        try (FileOutputStream fileOutputStream = new FileOutputStream("test1.txt", true);
             DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

             FileInputStream fileInputStream = new FileInputStream("test1.txt");
             DataInputStream ignored = new DataInputStream(fileInputStream)
        ) {
            dataOutputStream.writeInt(1989);
            dataOutputStream.writeDouble(6.4);

        }

    }
}
