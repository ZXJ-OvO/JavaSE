package com.zxj.day19;

import java.io.FileWriter;
import java.io.Writer;

/**
 * 文件字符输出流采用缓冲区的方案，数据全部来到缓冲区后一次性全部调入文件中，而缓冲区的数据转进文件需要刷新流或者关闭流
 * 关闭流包含了刷新流的操作，刷新流后流可以继续使用，关闭流后流就不可继续使用
 * 当缓冲区塞满，缓冲区的数据会先自动同步到文件中，为新数据进入缓冲区提供空间
 */
public class Question03 {
    public static void main(String[] args) {
        try (
                Writer fw = new FileWriter("src/main/resources/test.txt", true)
        ) {
            fw.write('a');
            fw.write(97);
            fw.write('美');
            fw.write("\r\n");

            fw.write("我爱你美国");
            fw.write("我爱你美国自由美利坚", 5, 5);  // 从索引开始往后个字符
            fw.write("\r\n");

            char[] chars = {'w', 'a', 'n', 'm', 'g'};

            fw.write(chars);
            fw.write(chars, 3, 2);
            fw.write("\r\n");
        } catch (Exception e) {

        }
    }
}
