package com.zxj.day18;

import java.io.FileWriter;
import java.util.Scanner;

/**
 * FileReader reader = new FileReader("src/main/resources/test.txt"),
 */
public class Question21 {
    public static void main(String[] args) throws Exception {
        try (
                FileWriter writer = new FileWriter("src/main/resources/test.txt", true)
        ) {
            writer.write('a');
            writer.write('美');
            writer.write(1989);
            writer.write(8964);
            writer.write("\r\n");

            writer.write("我爱你美国");
            writer.write("\r\n");

            writer.write("我爱你美国", 0, 5);
            writer.write("\r\n");

            char[] chars = {'一', '九', '八', '九', '六', '四'};
            writer.write(chars);
            writer.write("\r\n");

            writer.write(chars, 2, 4);
            writer.write("\r\n");

            System.out.println("你好");
            while (true){
                writer.write(new Scanner(System.in).nextLine());
                writer.flush();
            }
        }
    }
}
